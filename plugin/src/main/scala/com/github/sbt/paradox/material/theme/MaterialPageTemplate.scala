package com.github.sbt.paradox.material.theme

import com.lightbend.paradox.template.PageTemplate
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.Locale
import org.stringtemplate.v4.{ AttributeRenderer, NoIndentWriter, ST, STRawGroupDir, StringRenderer }
import scala.jdk.CollectionConverters._

// PageTemplate's template group is private, so rendering uses our own group
// with an explicit format="html" for escaped text and quoted attributes.
private[theme] final class MaterialPageTemplate(directory: File, name: String) extends PageTemplate(directory, name) {
  private val templates = new STRawGroupDir(directory.getAbsolutePath, '$', '$')
  private val renderer = new StringRenderer
  templates.registerRenderer(
    classOf[String],
    new AttributeRenderer[String] {
      override def toString(value: String, format: String, locale: Locale): String =
        if (format == "html") StringRenderer.escapeHTML(value).replace("\"", "&quot;").replace("'", "&#39;")
        else renderer.toString(value, format, locale)
    }
  )

  override def write(name: String, contents: PageTemplate.Contents, target: File): File =
    render(name, target) { template =>
      for ((key, value) <- contents.getProperties.asScala if !key.contains(".")) template.add(key, value)
      template.add("page", contents)
    }

  override def writeSingle(
      name: String,
      firstPage: PageTemplate.Contents,
      contents: Seq[PageTemplate.Contents],
      target: File
  ): File =
    render(name, target) { template =>
      template.add("page", firstPage)
      template.add("pages", contents.asJava)
    }

  override def writePrintCover(name: String, contents: PageTemplate.Contents, target: File): File =
    render(name, target)(_.add("page", contents))

  private def render(name: String, target: File)(addVars: ST => Unit): File = {
    val template = Option(templates.getInstanceOf(name)).getOrElse {
      sys.error(
        s"StringTemplate '$name' was not found for '$target'. Create a template or set a theme that contains one."
      )
    }
    addVars(template)
    val writer = Files.newBufferedWriter(target.toPath, StandardCharsets.UTF_8)
    try template.write(new NoIndentWriter(writer))
    finally writer.close()
    target
  }
}
