# Getting started

In order to enable the theme just add one of the following lines to your
project's `build.sbt`:

@@@ vars
``` sbt
paradoxTheme := Some("io.github.jonas" % "paradox-material-theme" % "$project.version$")
```
@@@

The theme can be configured via Paradox properties configured in your
project's `build.sbt` or for each individual page via the [front matter].
See the following sections for available options.

 [front matter]: http://developer.lightbend.com/docs/paradox/latest/features/templating.html#properties-front-matter

## Changing the color palette

A default hue is defined for every primary and accent color on Google's
Material Design [color palette][10], which makes it very easy to change the
overall look of the theme. Just set the primary and accent colors using the
following variables:

@@ snip [build.sbt]($root$/build.sbt) { #color }

Color names are case-insensitive, but must match the names of the Material
Design color palette. Valid values are: `red`, `pink`, `purple`, `deep purple`,
`indigo`, `blue`, `light blue`, `cyan`, `teal`, `green`, `light green`, `lime`,
`yellow`, `amber`, `orange`, `deep orange`, `brown`, `grey` and `blue grey`.
The last three colors can only be used as a primary color.

If the color is set via this configuration, an additional CSS file that
defines the color palette is automatically included. If you want to keep things
lean, clone the repository and recompile the theme with your custom colors set.
See the guide on @ref:[customization](customization.md) for more information.

  [10]: http://www.materialui.co/colors

### Primary colors

Click on a tile to change the primary color of the theme:

<button data-md-color-primary="red">Red</button>
<button data-md-color-primary="pink">Pink</button>
<button data-md-color-primary="purple">Purple</button>
<button data-md-color-primary="deep-purple">Deep Purple</button>
<button data-md-color-primary="indigo">Indigo</button>
<button data-md-color-primary="blue">Blue</button>
<button data-md-color-primary="light-blue">Light Blue</button>
<button data-md-color-primary="cyan">Cyan</button>
<button data-md-color-primary="teal">Teal</button>
<button data-md-color-primary="green">Green</button>
<button data-md-color-primary="light-green">Light Green</button>
<button data-md-color-primary="lime">Lime</button>
<button data-md-color-primary="yellow">Yellow</button>
<button data-md-color-primary="amber">Amber</button>
<button data-md-color-primary="orange">Orange</button>
<button data-md-color-primary="deep-orange">Deep Orange</button>
<button data-md-color-primary="brown">Brown</button>
<button data-md-color-primary="grey">Grey</button>
<button data-md-color-primary="blue-grey">Blue Grey</button>

<script>
  var buttons = document.querySelectorAll("button[data-md-color-primary]");
  Array.prototype.forEach.call(buttons, function(button) {
    button.addEventListener("click", function() {
      document.body.dataset.mdColorPrimary = this.dataset.mdColorPrimary;
    })
  })
</script>

### Accent colors

Click on a tile to change the accent color of the theme:

<button data-md-color-accent="red">Red</button>
<button data-md-color-accent="pink">Pink</button>
<button data-md-color-accent="purple">Purple</button>
<button data-md-color-accent="deep-purple">Deep Purple</button>
<button data-md-color-accent="indigo">Indigo</button>
<button data-md-color-accent="blue">Blue</button>
<button data-md-color-accent="light-blue">Light Blue</button>
<button data-md-color-accent="cyan">Cyan</button>
<button data-md-color-accent="teal">Teal</button>
<button data-md-color-accent="green">Green</button>
<button data-md-color-accent="light-green">Light Green</button>
<button data-md-color-accent="lime">Lime</button>
<button data-md-color-accent="yellow">Yellow</button>
<button data-md-color-accent="amber">Amber</button>
<button data-md-color-accent="orange">Orange</button>
<button data-md-color-accent="deep-orange">Deep Orange</button>

<script>
  var buttons = document.querySelectorAll("button[data-md-color-accent]");
  Array.prototype.forEach.call(buttons, function(button) {
    button.addEventListener("click", function() {
      document.body.dataset.mdColorAccent = this.dataset.mdColorAccent;
    })
  })
</script>

## Changing the font family

By default the [Roboto font family][12] is included with the theme, specifically
the regular sans-serif type for text and the `monospaced` type for code. Both
fonts are loaded from [Google Fonts][13] and can be changed to other fonts,
like for example the [Ubuntu font family][14]:

@@ snip [build.sbt]($root$/build.sbt) { #font }

The text font will be loaded in weights 400 and **700**, the `monospaced` font
in regular weight. If you want to load fonts from other destinations or don't
want to use the Google Fonts loading magic, just set `font` to `false`:

@@ snip [build.sbt]($root$/build.sbt) { #font-disable }

  [12]: https://fonts.google.com/specimen/Roboto
  [13]: https://fonts.google.com
  [14]: https://fonts.google.com/specimen/Ubuntu

## Adding a source repository

To include a link to the repository of your project within your documentation,
set the following variables via your project's `build.sbt`:

@@ snip [build.sbt]($root$/build.sbt) { #repository }

The name of the repository will be rendered next to the search bar on big
screens and as part of the main navigation drawer on smaller screen sizes.
Furthermore, set `material.repo.type` to `github`, `bitbucket` or `gitlab` to
render the respective service logo next to the name of the repository.
When the type is set to GitHub, the number of stars and forks is shown.

@@@ note { title="Why is there an edit button at the bottom of every article?" .question }

If `github.base_url` is set, an edit button will appear at the bottom of every
article. This behaviour is provided by Paradox. See the [Paradox documentation][15]
on more guidance regarding the `$page.source_url$` attribute, which defines whether the edit
button is shown or not.

@@@

  [15]: http://developer.lightbend.com/docs/paradox/latest/features/templating.html

## Adding a favicon

A favicon can be added by setting the `material.favicon` variable to an `.ico` or
image file:

@@ snip [build.sbt]($root$/build.sbt) { #favicon }

## Adding a logo

Your logo should have a rectangular shape with a minimum resolution of 128x128,
leave some room towards the edges and be composed of high contrast areas on a
transparent ground, as it will be placed on the colored header bar and drawer.
Simply create the folder `assets/images`, add your logo and embed it with:

@@ snip [build.sbt]($root$/build.sbt) { #logo }

Additionally, the default icon can be changed by setting an arbitrary ligature
(or Unicode code point) from the [Material Design icon font][16], e.g.

@@ snip [build.sbt]($root$/build.sbt) { #logo-icon }

  [16]: https://material.io/icons/

## Adding social links

Social accounts can be linked in the footer of the documentation using the
automatically included [FontAwesome][17] webfont. They are configured by setting
`material.social.<service>` to the URL you want to link to. The following social
services are supported: `github`, `gitlab`, `bitbucket`, `linkedin`, `twitter`,
`facebook` and finally `web` for website links:

@@ snip [build.sbt]($root$/build.sbt) { #social }

The links are generated in a pre-defined order and cannot be changed.

  [17]: http://fontawesome.io/icons/

## Copyright Notice

To display a copyright notice in the footer set `material.copyright` to the
text you want to show. Any HTML markup, such as links, can be used:

@@ snip [build.sbt]($root$/build.sbt) { #copyright }

## Language

You can define the language of each page with `material.language`:

@@ snip [build.sbt]($root$/build.sbt) { #language }

This will add a `lang` attribute to the top-level `html` element:

```html
<!DOCTYPE html>
<html lang="en" class="no-js">
  ...
</html>
```

If no language is set English (`en`) is assumed.

## Google Analytics integration

The theme makes it easy to integrate site tracking with Google Analytics.
Besides basic tracking, clicks on all outgoing links can be tracked as well as
how site search is used. Tracking can be activated in your project's
`build.sbt`:

@@ snip [build.sbt]($root$/build.sbt) { #analytics }

## More advanced customization

If you want to change the general appearance of the Material theme, see
@ref:[the customization guide](customization.md) for more information.
