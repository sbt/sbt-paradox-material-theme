package io.github.jonas.paradox.material.theme

import java.net.{URI, URLEncoder}
import java.util.Locale
import org.stringtemplate.v4.StringRenderer

case class ParadoxMaterialTheme(properties: Map[String, String]) {
  import ParadoxMaterialTheme._

  def withLanguage(locale: Locale) =
    withProperties("language" -> locale.getLanguage)

  def withColor(primary: String, accent: String) =
    withProperties(
      "color.primary" -> primary,
      "color.accent"  -> accent
    )

  def withFavicon(favicon: String) =
    withProperties("favicon" -> favicon)

  def withLogo(logo: String) =
    withProperties("logo" -> logo)

  def withLogoIcon(icon: String) =
    withProperties("logo.icon" -> icon)

  def withFont(text: String, code: String) =
    withProperties(
      "font.text" -> text,
      "font.text.url" -> URLEncoder.encode(text, "UTF-8"),
      "font.code" -> code,
      "font.code.url" -> URLEncoder.encode(code, "UTF-8")
    )

  def withoutFont() =
    copy(properties = properties -- Seq("font.text", "font.code"))

  def withSearch(tokenizer: String = "[\\s\\-]+") =
    withProperties(
      "search" -> "true",
      "search.tokenizer" -> tokenizer
    )

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
  }
}
