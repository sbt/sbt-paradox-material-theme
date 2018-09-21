# Release notes

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
