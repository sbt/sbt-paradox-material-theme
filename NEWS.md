# Release notes

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
