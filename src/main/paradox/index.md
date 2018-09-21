# Paradox Material Theme

@@@ index
 - [getting-started](getting-started.md)
 - [customization](customization.md)
 - [specimen](specimen/index.md)
 - [release notes](release-notes.md)
@@@

## Beautiful project documentation

Paradox Material Theme is a theme for [Paradox], a static site generator geared
towards project documentation. It is based on the excellent [MkDocs Material]
theme which is built using Google's [Material Design] guidelines.

[![Material for MkDocs](images/material.png)](images/material.png)

  [Paradox]: https://github.com/lightbend/paradox
  [MkDocs Material]: https://github.com/squidfunk/mkdocs-material
  [Material Design]: https://material.io/guidelines/material-design/

## Quick start

Install the latest version of the theme by adding the following line to your
project's `project/plugins.sbt`:

@@@ vars
``` sbt
addSbtPlugin("io.github.jonas" % "sbt-paradox-material-theme" % "$project.version$")
```
@@@

And enabling the theme plugin in your project's `build.sbt`:

@@ snip [build.sbt]($root$/plugin/src/sbt-test/paradox/can-use-theme/build.sbt) { #enable-plugin }

For detailed instructions see the @ref:[getting started guide](getting-started.md).

## What to expect

* Responsive design and fluid layout for all kinds of screens and devices,
  designed to serve your project documentation in a user-friendly way with
  optimal readability.

* Easily customizable primary and accent color, fonts, favicon and logo;
  integrated with Google Analytics and GitHub.

* Well-designed search interface accessible through hotkeys (<kbd>F</kbd> or
  <kbd>S</kbd>), intelligent grouping of search results, search term
  highlighting and lazy loading.

* Support most Paradox features except for [groups].

The @ref:[specimen pages] show examples of the theme in action, such as
[callouts] and [tabbed snippets].

 [specimen pages]: specimen/index.md
 [callouts]: specimen/callouts.md
 [tabbed snippets]: specimen/tabbed-snippets.md
 [groups]: http://developer.lightbend.com/docs/paradox/current/groups.html
