# Customization

Project documentation is as diverse as the projects themselves and the Material
theme is a good starting point for making it look great. However, as you write
your documentation, you may reach a point where some small adjustments are
necessary to preserve the desired style.

The theme provides several ways to customize from including a custom stylesheet
and JavaScript code to overriding the individual templates.

## Additional stylesheets

If you want to tweak some colors or change the spacing of certain elements,
you can do this in a separate stylesheet. The easiest way is by creating a
new stylesheet file in your `src/main/paradox` directory:

``` sh
mkdir -p src/main/paradox/assets
touch src/main/paradox/assets/custom.css
```

Then, add the following line to your `build.sbt`:

@@ snip [build.sbt]($root$/build.sbt) { #custom-stylesheet }

Start typing your changes in your additional stylesheet file – you can see them
after saving and running `paradox`.

## Additional JavaScript

The same is true for additional JavaScript. If you want to integrate another
syntax highlighter or add some custom logic to your theme, create a new
JavaScript file in your `src/main/paradox` directory:

``` sh
mkdir -p src/main/paradox/assets
touch src/main/paradox/assets/custom.js
```

Then, add the following line to your `build.sbt`:

@@ snip [build.sbt]($root$/build.sbt) { #custom-javascript }

## Extending the theme

If you want to alter the HTML source (e.g. add or remove some part), you can
extend the theme. Paradox allowing a way to [modify a theme] without
forking and changing the main theme. By default, files can be added in
`src/main/paradox/_template` to override those provided by the theme.

 [modify a theme]: http://developer.lightbend.com/docs/paradox/current/customization/theming.html#modify-a-theme

The structure in the theme directory must mirror the directory structure of the
original theme, as any file in the theme directory will replace the file with
the same name which is part of the original theme. Besides, further assets
may also be put in the theme directory.

The directory layout of the theme is as follows:

``` sh
.
├── assets
│   ├── images                     # Images and icons
│   ├── javascripts                # JavaScript
│   └── stylesheets                # Stylesheets
├── partials
│   ├── footer.st                  # Page footer
│   ├── header.st                  # Page header
│   ├── nav.st                     # Main navigation
│   ├── poweredby.st               # Powered-by footer message
│   ├── search.st                  # Search box
│   ├── social.st                  # Social links
│   ├── source.st                  # Repository information
│   └── toc.st                     # Table of contents
└── page.st                        # Page base template
```

## Overriding partials

In order to override the footer, we can replace the `footer.st` partial with
our own partial. To do this, create the file `partials/footer.st` in the
theme directory. Paradox will now use the new partial when rendering the theme.
This can be done with any file.
