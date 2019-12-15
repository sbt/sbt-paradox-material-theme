package io.github.jonas.paradox.material.theme

import java.net.{URI, URLEncoder}
import java.util.Locale
import org.stringtemplate.v4.StringRenderer

case class ParadoxMaterialTheme(properties: Map[String, String]) {
  import ParadoxMaterialTheme._

  def withLanguage(locale: Locale) =
    withProperties("language" -> locale.getLanguage)

  def withColor(primaryColor: String, accentColor: String) = {
    val primary = primaryColor.replace(" ", "-").toLowerCase
    val accent = accentColor.replace(" ", "-").toLowerCase
    val colorProps = withProperties(
      "color.primary" -> primary,
      "color.accent" -> accent
    )
    ParadoxMaterialTheme.Palette.Primary.get(primary) match {
      case Some(themeColor) => colorProps.withProperties("color.primary.theme" -> themeColor)
      case None             => colorProps
    }
  }

  def withFavicon(favicon: String) =
    withProperties("favicon" -> favicon)

  def withLogo(logo: String) = {
    withProperties("logo" -> logo)
      .withoutProperties("logo.icon", "logo.uri")
  }

  def withLogoUri(uri: URI) = {
    withProperties("logo.uri" -> StringRenderer.escapeHTML(uri.toString))
      .withoutProperties("logo", "logo.icon")
  }

  def withLogoIcon(icon: String) = {
    withProperties("logo.icon" -> icon)
      .withoutProperties("logo", "logo.uri")
  }

  def withFont(text: String, code: String) =
    withProperties(
      "font.text" -> text,
      "font.text.url" -> URLEncoder.encode(text, "UTF-8"),
      "font.code" -> code,
      "font.code.url" -> URLEncoder.encode(code, "UTF-8")
    )

  def withoutFont() =
    withoutProperties("font.text", "font.code")

  def withSearch(tokenizer: String = "[\\s\\-]+") =
    withProperties(
      "search" -> "true",
      "search.tokenizer" -> tokenizer
    )

  def withoutSearch() =
    withoutProperties("search", "search.tokenizer")

  def withSearchLanguage(languages: String*) = {
    // See(mkdocs-material v3.0.3) https://github.com/squidfunk/mkdocs-material/blob/12a79817f057b09f05c3d7cffe8893dfe9c6bde9/material/base.html#L181-L200
    val scripts = "<script src=\"assets/javascripts/lunr/lunr.stemmer.support.js\"></script>" +: languages.flatMap { lang =>
      val lunrScript =
        if (Set("da", "de", "du", "es", "fi", "fr", "hu", "it", "jp", "no", "pt", "ro", "ru", "sv", "tr").contains(lang)) {
          Seq(s"""<script src="assets/javascripts/lunr/lunr.${lang}.js"></script>""")
        } else Seq.empty
      if (lang == "jp") {
        "<script src=\"assets/javascripts/lunr/tinyseg.js\"></script>" +: lunrScript
      } else lunrScript
    } :+ "<script src=\"assets/javascripts/lunr/lunr.multi.js\"></script>"
    withProperties("search.language" -> languages.mkString(","))
      .withProperties("search.scripts" -> scripts.mkString("\n"))
  }

  def withCopyright(copyright: String) =
    withProperties("copyright" -> copyright)

  def withGoogleAnalytics(ga: String) =
    withProperties("google.analytics" -> ga)

  def withSocial(uris: URI*) = {
    val html = uris.map { uri =>
      val site = SocialSite(uri).getOrElse("globe")
      val href = StringRenderer.escapeHTML(uri.toString)

      s"""<a href="$href" class="md-footer-social__link fa fa-$site"></a>"""
    }
    withProperties("social" -> html.mkString)
  }

  def withRepository(uri: URI) =
    withProperties(
      "repo" -> uri.toString,
      "repo.type" -> RepositoryType(uri).getOrElse(""),
      "repo.name" -> uri.getPath.dropWhile(_ == '/')
    )

  def withCustomStylesheet(path: String) =
    withProperties("custom.stylesheet" -> path)

  def withCustomJavaScript(path: String) =
    withProperties("custom.javascript" -> path)

  def paradoxProperties(): Map[String, String] =
    properties.map(p => s"material.${p._1}" -> p._2)
  override def toString = paradoxProperties().toString

  private def withProperties(props: (String, String)*): ParadoxMaterialTheme =
    copy(properties = properties ++ props.toMap)

  private def withoutProperties(keys: String*): ParadoxMaterialTheme =
    copy(properties = properties -- keys)
}

object ParadoxMaterialTheme {
  val Tlds = List("com", "org")
  def findSite(sites: String*): URI => Option[String] =
    uri => sites.find { service =>
      Tlds.exists(tld => uri.getHost.endsWith(service + "." + tld))
    }

  val SocialSite = findSite("bitbucket", "facebook", "github", "gitlab", "linkedin", "twitter")
  val RepositoryType = findSite("bitbucket", "github", "gitlab")

  def apply(): ParadoxMaterialTheme = {
    ParadoxMaterialTheme(Map.empty)
      .withFont("Roboto", "Roboto Mono")
      .withLogoIcon("local_library")
      .withFavicon("assets/images/favicon.png")
      .withSearch()
  }

  object Palette {
    val Primary = Map(
      "red"         -> "#ef5350",
      "pink"        -> "#e91e63",
      "purple"      -> "#ab47bc",
      "deep-purple" -> "#7e57c2",
      "indigo"      -> "#3f51b5",
      "blue"        -> "#2196f3",
      "light-blue"  -> "#03a9f4",
      "cyan"        -> "#00bcd4",
      "teal"        -> "#009688",
      "green"       -> "#4caf50",
      "light-green" -> "#7cb342",
      "lime"        -> "#c0ca33",
      "yellow"      -> "#f9a825",
      "amber"       -> "#ffa000",
      "orange"      -> "#fb8c00",
      "deep-orange" -> "#ff7043",
      "brown"       -> "#795548",
      "grey"        -> "#757575",
      "blue-grey"   -> "#546e7a"
    )
    val Accent = Map(
      "red"         -> "#ff1744",
      "pink"        -> "#f50057",
      "purple"      -> "#e040fb",
      "deep-purple" -> "#7c4dff",
      "indigo"      -> "#536dfe",
      "blue"        -> "#448aff",
      "light-blue"  -> "#0091ea",
      "cyan"        -> "#00b8d4",
      "teal"        -> "#00bfa5",
      "green"       -> "#00c853",
      "light-green" -> "#64dd17",
      "lime"        -> "#aeea00",
      "yellow"      -> "#ffd600",
      "amber"       -> "#ffab00",
      "orange"      -> "#ff9100",
      "deep-orange" -> "#ff6e40"
    )
  }
}
