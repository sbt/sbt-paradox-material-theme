# Release notes

## 0.8.0

 - sbt 2 support: the plugin is now cross-published for sbt 1 and sbt 2 [#209](https://github.com/sbt/sbt-paradox-material-theme/pull/209)
    - The same `addSbtPlugin("com.github.sbt" % "sbt-paradox-material-theme" % "0.8.0")` line works for both.
 - New minimum JDK: JDK 11 on sbt 1 (JDK 8 is no longer supported) and JDK 17 on sbt 2, see [Requirements](https://www.scala-sbt.org/sbt-paradox-material-theme/getting-started.html#requirements)
    - The plugin now depends on [Paradox version 0.11.1] (previously 0.9.2), the first Paradox release line published for sbt 2.
    - If you followed the previous JDK 11 instructions and added `sbt-paradox` and `sbt-paradox-theme` 0.10.6 to `project/plugins.sbt` yourself, remove those lines.
 - Add Open Graph and Twitter card metadata (`og:title`, `og:description`, `og:image`, `og:url`, `og:site_name`, `twitter:card`) [#31](https://github.com/sbt/sbt-paradox-material-theme/pull/31)
    - Set `description` and `project.image` in your build, see [Open Graph metadata](https://www.scala-sbt.org/sbt-paradox-material-theme/getting-started.html#open-graph-metadata).
 - Page metadata is now HTML-escaped [#31](https://github.com/sbt/sbt-paradox-material-theme/pull/31)
    - `title`, `description` and `author` (front matter or build properties), `project.description`, `project.image` and `material.canonical.url` are treated as plain text, so quotes and `<`, `>` no longer break the page.
    - HTML entities are no longer interpreted, in those values or in page titles taken from Markdown headings. `# Akka &amp; Pekko` now shows `&amp;`; write the character itself instead (`# Akka & Pekko`, `©`).
 - Fix `material.author` rendering an empty author meta tag, see [Author metadata](https://www.scala-sbt.org/sbt-paradox-material-theme/getting-started.html#author-metadata) [#31](https://github.com/sbt/sbt-paradox-material-theme/pull/31)
 - Fix duplicate `<meta name="description">` tag [#31](https://github.com/sbt/sbt-paradox-material-theme/pull/31)
 - Snapshots are now published for every commit to `main` [#130](https://github.com/sbt/sbt-paradox-material-theme/pull/130)
 - Update jsoup to version [1.23.2](https://github.com/jhy/jsoup/releases/tag/jsoup-1.23.2)
 - Update circe to version [0.14.16](https://github.com/circe/circe/releases/tag/v0.14.16).

 See the [GitHub release](https://github.com/sbt/sbt-paradox-material-theme/releases/tag/v0.8.0) for the full list of changes.

 [Paradox version 0.11.1]: https://github.com/lightbend/paradox/releases/tag/v0.11.1

## 0.7.0

 - Project is now called `sbt-paradox-material-theme` and moved to the [sbt](https://github.com/sbt) GitHub organization [#38](https://github.com/sbt/sbt-paradox-material-theme/pull/38)
 - Moved project to `com.github.sbt` Maven groupId [#39](https://github.com/sbt/sbt-paradox-material-theme/pull/39) and [#54](https://github.com/sbt/sbt-paradox-material-theme/pull/54)
 - Compatible with latest sbt-site 1.5.0 [#56](https://github.com/sbt/sbt-paradox-material-theme/pull/56)
    - See the sbt-site [Migration Guide](https://www.scala-sbt.org/sbt-site/migration-guide.html)
    - You don't need to call `ParadoxMaterialThemePlugin.paradoxMaterialThemeSettings(Paradox)` anymore
 - Fix duplicated slash in URL [#28](https://github.com/sbt/sbt-paradox-material-theme/pull/28)
 - Update to sbt-web [1.5.4](https://github.com/sbt/sbt-web/releases/tag/1.5.4).
 - Update jsoup to version [1.17.2](https://github.com/jhy/jsoup/releases/tag/jsoup-1.17.2)
 - Update circe to version [0.14.6](https://github.com/circe/circe/releases/tag/v0.14.6).
 - Update to [Paradox version 0.9.2].

 [Paradox version 0.9.2]: https://github.com/lightbend/paradox/releases/tag/v0.9.2

## 0.6.0

 - Update circe to version [0.9.3](https://github.com/circe/circe/releases/tag/v0.9.3).
 - Update to [Paradox version 0.4.4].

 [Paradox version 0.4.4]: https://github.com/lightbend/paradox/releases/tag/v0.4.4

## 0.5.1

 - Bump sbt to version 1.2.3.
 - Update to [Paradox version 0.4.2].
 - Keep the sidebar navigation order when updating link classes. [#15]

 [#15]: https://github.com/jonas/paradox-material-theme/issues/15
 [Paradox version 0.4.2]: https://github.com/lightbend/paradox/releases/tag/v0.4.2

## 0.5.0

 - Update to [mkdocs-material-3.0.3].
 - Update to [Paradox version 0.4.0].
 - Link to logo URI using `withLogoUri()`.
 - Refactor display of the project version so the right navigation
   menu's scroll bar is only visible when the page footer overlaps.

 [mkdocs-material-3.0.3]: https://github.com/squidfunk/mkdocs-material/releases/tag/3.0.3
 [Paradox version 0.4.0]: https://github.com/lightbend/paradox/releases/tag/v0.4.0

## 0.4.0

 - Update to [mkdocs-material-2.2.2].
 - Add support for hero text by defining `material.hero` in the front matter.
 - Add workaround for using `previewSite` when developing. [#7]

 [mkdocs-material-2.2.2]: https://github.com/squidfunk/mkdocs-material/releases/tag/2.2.2
 [#7]: https://github.com/jonas/paradox-material-theme/issues/7

## 0.3.0

 - Add sbt plugin to help configure the theme using a builder-like API.
 - Enable search by default.
 - Build with sbt 1.0.
 - Add the theme version to the generator string.

## 0.2.0

 - Update to [mkdocs-material-1.11.0].
 - Support site search. [#1]
 - Show version, wrap code and hide clipboard icon when printing. [#4]
 - Document `material.language`.
 - Make certain messages translatable.

 [mkdocs-material-1.11.0]: https://github.com/squidfunk/mkdocs-material/releases/tag/1.11.0
 [#1]: https://github.com/jonas/paradox-material-theme/issues/1
 [#4]: https://github.com/jonas/paradox-material-theme/issues/4

## 0.1.1

 - Show the project version number in both drawer and "desktop" mode.

## 0.1.0

 - Initial version based on [MkDocs Material] version 1.10.2. Unsupported
   features from the upstream theme includes: Disqus integration, search,
   tabs navigation and localization.

 [MkDocs Material]: https://github.com/squidfunk/mkdocs-material
