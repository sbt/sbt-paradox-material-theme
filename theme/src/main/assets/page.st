$!
  Copyright (c) 2016-2018 Martin Donath <martin.donath@squidfunk.com>
  Copyright (c) 2017-2018 Jonas Fonseca <jonas.fonseca@gmail.com>

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to
  deal in the Software without restriction, including without limitation the
  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
  sell copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
  IN THE SOFTWARE.
!$
<!DOCTYPE html>
<html lang="$page.properties.("material.language"); null="en"$" class="no-js">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="$page.properties.("project.description")$">
    <meta name="generator" content="Paradox, paradox-material-theme=$page.properties.("material.theme.version")$, mkdocs-material-9.5.11">

    $partials/language()$

    $ if (page.properties.("description")) $
      <meta name="description" content="$page.properties.("description")$">
    $ elseif (page.properties.("project.description")) $
      <meta name="description" content="$page.properties.("project.description")$">
    $ endif $
    $ if (page.properties.("material.canonical.url")) $
      <link rel="canonical" href="$page.properties.("material.canonical.url")$">
    $ endif $
    $ if (page.properties.("author")) $
      <meta name="author" content="$page.properties.("author")$">
    $ elseif (page.properties.("material.author")) $
      <meta name="author" content="$page.properties.("site.author")$">
    $ endif $
    <link rel="prev" href="$page.prev.href$" />
    <link rel="next" href="$page.next.href$" />
    <link rel="shortcut icon" href="$page.base$$page.properties.("material.favicon")$">
    $ if (page.properties.("title")) $
      <title>$page.properties.("title")$</title>
    $ elseif (page.title) $
      <title>$page.title$$ if (!page.home.active) $ · $page.home.title$$ endif $</title>
    $ else $
      <title>$page.home.title$</title>
    $ endif $
    <link rel="stylesheet" href="$page.base$assets/stylesheets/main.7e359304.min.css">
    $ if (page.properties.("material.color.primary")) $
      <link rel="stylesheet" href="$page.base$assets/stylesheets/palette.06af60db.min.css">
      $ if (page.properties.("material.color.primary.theme")) $
        <meta name="theme-color" content="$page.properties.("material.color.primary.theme")$" />
      $ endif $
    $ endif $
    <link rel="stylesheet" href="$page.base$lib/material__tabs/dist/mdc.tabs.min.css">
    <link rel="stylesheet" href="$page.base$lib/prettify/prettify.css">
    <script src="$page.base$assets/javascripts/modernizr.1aa3b519.js"></script>
    $ if (page.properties.("material.font.text")) $
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=$page.properties.("material.font.text.url")$:300,400,400i,700|$page.properties.("material.font.code.url")$">
      <style>
        body,input{font-family:"$page.properties.("material.font.text")$","Helvetica Neue",Helvetica,Arial,sans-serif}
        code,kbd,pre{font-family:"$page.properties.("material.font.code")$","Courier New",Courier,monospace}
      </style>
    $ endif $
    <link rel="stylesheet" href="$page.base$assets/fonts/font-awesome.css">
    <link rel="stylesheet" href="$page.base$assets/fonts/material-icons.css">
    <link rel="stylesheet" href="$page.base$assets/stylesheets/paradox-material-theme.css">
    $ if (page.properties.("material.custom.stylesheet")) $
      <link rel="stylesheet" href="$page.base$$page.properties.("material.custom.stylesheet")$">
    $ endif $
  </head>
  <body
    $ if (page.properties.("material.color.scheme")) $
      data-md-color-scheme="$page.properties.("material.color.scheme")$"
    $ endif $
    $ if (page.properties.("material.color.primary")) $
      data-md-color-primary="$page.properties.("material.color.primary")$"
    $ endif $
    $ if (page.properties.("material.color.accent")) $
      data-md-color-accent="$page.properties.("material.color.accent")$"
    $ endif $
  dir="ltr">
    <input class="md-toggle" data-md-toggle="drawer" type="checkbox" id="__drawer" autocomplete="off" />
    <input class="md-toggle" data-md-toggle="search" type="checkbox" id="__search" autocomplete="off"/>
    <label class="md-overlay" for="__drawer"></label>
    $! TODO Skip to content !$
    $! TODO Announcement bar !$
    $partials/header()$
    <div class="md-container" data-md-component="container">
      <main class="md-main" data-md-component="main">
        <div class="md-main__inner md-grid">
          $! Navigation !$
          <div class="md-sidebar md-sidebar--primary" data-md-component="sidebar" data-md-type="navigation">
            <div class="md-sidebar__scrollwrap">
              <div class="md-sidebar__inner">
                $partials/nav()$
              </div>
            </div>
          </div>

          $! Table of contents !$
          $ if (page.subheaders) $
            <div class="md-sidebar md-sidebar--secondary" data-md-component="sidebar" data-md-type="toc">
              <div class="md-sidebar__scrollwrap">
                <div class="md-sidebar__inner">
                  $partials/toc()$
                </div>
              </div>
            </div>
          $ endif $

          $! Page content !$
          <div class="md-content" data-md-component="content">
            <article class="md-content__inner md-typeset">
              $partials/content()$
            </article>
          </div>

         $! User preference: content !$
         <script>
           var target = document.getElementById(location.hash.slice(1))
           if (target && target.name)
             target.checked = target.name.startsWith("__tabbed_")
         </script>
        </div>
        $partials/top()$
      </main>
      $partials/footer()$
    </div>
    <script src="$page.base$assets/javascripts/paradox-material-theme.js"></script>
    $!

      The ending "." enables search to work without providing the site URL, since the
      theme JavaScript fetches the index by concatenating the base URL to an absolute
      path: "/search/search_index.json".

      It originally was "./" but this breaks previewSite because it leads to a double
      slash when fetching the index, i.e. ".//search/...". To complete the workaround
      all locations in the search index now start with a "/" so the JavaScript can
      safely do: `url.base + doc.location`.

    !$
    <script id="__config" type="application/json">
      {
                "base":  "$page.base$.",
                "features":  [
                          "navigation.path",
                          "navigation.prune",
                          "navigation.indexes",
                          "toc.follow",
                          "navigation.top",
                          "search.suggest",
                          "search.highlight",
                          "content.code.copy",
                          "navigation.footer",
                          "content.action.edit",
                          "content.tooltips"
                ],
                "search":  "$page.base$assets/javascripts/workers/search.b8dbb3d2.min.js",
                "translations":  {
                          "clipboard.copied":  "Copied to clipboard",
                          "clipboard.copy":  "Copy to clipboard",
                          "search.result.more.one":  "1 more on this page",
                          "search.result.more.other":  "# more on this page",
                          "search.result.none":  "No matching documents",
                          "search.result.one":  "1 matching document",
                          "search.result.other":  "# matching documents",
                          "search.result.placeholder":  "Type to start searching",
                          "search.result.term.missing":  "Missing",
                          "select.version":  "Select version"
                }
    }</script>
    <script src="$page.base$assets/javascripts/bundle.8fd75fb4.min.js"></script>
    <script type="text/javascript" src="$page.base$lib/prettify/prettify.js"></script>
    <script type="text/javascript" src="$page.base$lib/prettify/lang-scala.js"></script>
    <script type="text/javascript">
      document.addEventListener("DOMContentLoaded", function(event) {
        window.prettyPrint && prettyPrint();
      });
    </script>
    $ if (page.properties.("material.custom.javascript")) $
      <script src="$page.base$$page.properties.("material.custom.javascript")$"></script>
    $ endif $
    $ if (page.properties.("material.google.analytics")) $
      $partials/integrations/analytics()$
    $ endif $
  </body>
</html>
