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

<header class="md-header" data-md-component="header">
  <nav class="md-header__inner md-grid" aria-label="Header">
      $! Link to home !$
      <a
        href="$page.home.href$"
        title="$page.home.title$"
        class="md-header__button md-logo"
        aria-label="$page.home.title$"
        data-md-component="logo"
      >
        $logo()$
      </a>
    $! Button to open drawer !$
    <label class="md-header__button md-icon" for="__drawer">
      $logo()$
    </label>

    $! Header title !$
    <div class="md-header__title" data-md-component="header-title">
      <div class="md-header__ellipsis">
        <div class="md-header__topic">
          <span class="md-ellipsis">
           $page.home.title$
          </span>
        </div>
        <div class="md-header__topic" data-md-component="header-topic">
          <span class="md-ellipsis">
            $ if (page.home.active) $
              $page.home.title$
            $ else $
              $page.title$
            $ endif $
          </span>
        </div>
      </div>
    </div>


    $! Button to open search modal !$
    $ if (page.properties.("material.search")) $
      <label class="md-header__button md-icon" for="__search">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
            <path d="M9.5 3A6.5 6.5 0 0116 9.5c0 1.61-.59 3.09-1.56 4.23l.27.27h.79l5 5-1.5 1.5-5-5v-.79l-.27-.27A6.516 6.516 0 019.5 16 6.5 6.5 0 013 9.5 6.5 6.5 0 019.5 3m0 2C7 5 5 7 5 9.5S7 14 9.5 14 14 12 14 9.5 12 5 9.5 5z"/>
        </svg>
      </label>

      $! Search interface !$
      $search()$
    $ else $
      <form name="search" style="display: none">
        <input type="text" name="query">
      </form>
    $ endif $

    $! Repository information !$
    $ if (page.properties.("material.repo")) $
      <div class="md-header__source">
        $source()$
      </div>
    $ endif $
    </nav>
</header>
