package io.github.jonas.paradox.material.theme

import scala.collection.JavaConverters._
import com.lightbend.paradox.sbt.ParadoxPlugin.autoImport.paradoxMarkdownToHtml
import io.circe._
import io.circe.syntax._
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import sbt._
import sbt.Keys._

case class SearchIndex(docs: Seq[SearchIndex.Section])

object SearchIndex {
  implicit val encoder: ObjectEncoder[SearchIndex] = Encoder.forProduct1("docs")(_.docs)

  case class Section(location: String, title: String, text: String)
  object Section {
    implicit val encoder: ObjectEncoder[Section] = Encoder.forProduct3("location", "text", "title")(
      page => ("/" + page.location, page.text, page.title))
  }

  val Headers = Set("h1", "h2", "h3", "h4", "h5", "h6")

  def generate(target: File, mappings: Seq[(File, String)]): File = {
    def readSections(mapping: (File, String)): Seq[Section] = {
      val (file, location) = mapping
      val doc = Jsoup.parse(file, "UTF-8")
      val docTitle = {
        val title = doc.select("head title").text()
        Option(title.lastIndexOf(" · "))
          .filter(_ > 0)
          .map(title.substring(0, _))
          .getOrElse(title)
      }

      def headerLocation(header: Element) =
        Option(header.select("a[name]").first()) match {
          case Some(anchor) => location + "#" + anchor.attr("name")
          case None         => location
        }

      def processElement(section: Section, elements: List[Element]): Seq[Section] =
        elements match {
          case header :: tail if Headers(header.tagName) =>
            val location = headerLocation(header)
            val next = Section(location, header.text, "")
            Vector(section) ++ processElement(next, tail)
          case element :: tail =>
            val text =
              if (section.text.isEmpty) element.text
              else section.text + "\n" + element.text
            processElement(section.copy(text = text.trim), tail)
          case Nil =>
            Vector(section)
        }

      val elements =
        doc.select("body .md-content__searchable").asScala.flatMap(_.children.asScala).toList

      processElement(Section(location, docTitle, ""), elements)
    }

    val sections = mappings.flatMap(readSections).toList
    val searchIndex = SearchIndex(sections)
    val json = searchIndex.asJson.noSpaces
    val out = target / "search_index.json"
    IO.write(out, json)
    out
  }

  def mapping(scope: Configuration) = Def.task {
    val index = generate(
      (target in scope).value / "paradox-material-theme",
      (paradoxMarkdownToHtml in scope).value
    )
    index -> "search/search_index.json"
  }
}
