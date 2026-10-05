import org.jsoup.Jsoup
import org.jsoup.nodes.Document

name := "open-graph"

enablePlugins(ParadoxMaterialThemePlugin)

val homeTitle = "Paradox & Site &copy;"
val projectDescription = """Project "description" & <details> &copy;"""
val projectImage = "https://example.org/images/preview.png?size=large&name=docs"
val pageTitle = """Custom "title" & <Guide> &copy;"""
val pageDescription = """Page "description" & <details> &copy;"""
val pageImage = "https://example.org/images/page.png?size=large&name=page"
val pageUrl = "https://example.org/docs/override.html?lang=en&edition=full"
val siteAuthor = """Site "author" & <Co>"""
val pageAuthor = """Page "author" & <Co>"""

Compile / paradoxProperties ++= Map(
  "project.description" -> projectDescription,
  "project.image" -> projectImage,
  "material.author" -> siteAuthor
)

Compile / paradoxMaterialTheme ~= {
  _.withCopyright("<strong>Copyright</strong>")
}

def checkMeta(doc: Document, property: String, expected: Option[String]): Unit = {
  val tags = doc.select(s"""meta[property="$property"]""")
  expected match {
    case Some(value) =>
      assert(tags.size() == 1, s"Expected one $property tag in ${doc.location()}, found $tags")
      assert(tags.first().attr("content") == value, s"Expected $property='$value', found $tags")
      assert(tags.first().attributes().size() == 2, s"Unexpected attributes in $tags")
    case None =>
      assert(tags.isEmpty(), s"Expected no $property tag in ${doc.location()}, found $tags")
  }
}

def checkPage(
    file: File,
    title: String,
    author: String,
    description: Option[String],
    image: Option[String],
    url: Option[String] = None
): Unit = {
  val doc = Jsoup.parse(file, "UTF-8")
  assert(doc.select(".md-footer-copyright strong").text() == "Copyright", "Copyright HTML was escaped")
  assert(doc.title() == title, s"Expected title '$title', found '${doc.title()}'")
  checkMeta(doc, "og:title", Some(title))
  checkMeta(doc, "og:description", description)
  checkMeta(doc, "og:image", image)
  checkMeta(doc, "og:type", Some("website"))
  checkMeta(doc, "og:site_name", Some(homeTitle))
  checkMeta(doc, "og:url", url)

  val cards = doc.select("""meta[name="twitter:card"]""")
  val card = if (image.isDefined) "summary_large_image" else "summary"
  assert(cards.size() == 1 && cards.first().attr("content") == card, s"Expected twitter:card '$card', found $cards")

  val descriptions = doc.select("meta[name=description]")
  assert(descriptions.size() == description.size, s"Unexpected description tags in ${file.getName}: $descriptions")
  description.foreach { value =>
    assert(descriptions.first().attr("content") == value, s"Unexpected description: $descriptions")
  }
  val authors = doc.select("meta[name=author]")
  assert(authors.size() == 1, s"Expected one author tag in ${file.getName}, found $authors")
  assert(authors.first().attr("content") == author, s"Expected author '$author', found $authors")
  assert(authors.first().attributes().size() == 2, s"Unexpected attributes in $authors")

  val canonical = doc.select("link[rel=canonical]")
  assert(canonical.size() == url.size, s"Unexpected canonical links in ${file.getName}: $canonical")
  url.foreach { value =>
    assert(canonical.first().attr("href") == value, s"Unexpected canonical URL: $canonical")
  }
}

TaskKey[Unit]("checkMetadata") := {
  val dest = (Compile / paradox / target).value
  checkPage(dest / "index.html", homeTitle, siteAuthor, Some(projectDescription), Some(projectImage))
  checkPage(
    dest / "heading.html",
    s"Markdown & guide · $homeTitle",
    siteAuthor,
    Some(projectDescription),
    Some(projectImage)
  )
  checkPage(dest / "override.html", pageTitle, pageAuthor, Some(pageDescription), Some(pageImage), Some(pageUrl))
}

TaskKey[Unit]("checkMissingProperties") := {
  val dest = (Compile / paradox / target).value
  checkPage(dest / "index.html", homeTitle, siteAuthor, None, None)
  checkPage(dest / "heading.html", s"Markdown & guide · $homeTitle", siteAuthor, None, None)
  checkPage(dest / "override.html", pageTitle, pageAuthor, Some(pageDescription), Some(pageImage), Some(pageUrl))
}
