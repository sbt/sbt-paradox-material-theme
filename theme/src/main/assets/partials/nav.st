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
<nav class="md-nav md-nav--primary" aria-label="Navigation" data-md-level="0">
    <label class="md-nav__title" for="__drawer">
        <a href="$page.home.href$" title="$page.home.title$" class="md-nav__button md-logo" aria-label="$page.home.title$">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <path d="M12 8a3 3 0 003-3 3 3 0 00-3-3 3 3 0 00-3 3 3 3 0 003 3m0 3.54C9.64 9.35 6.5 8 3 8v11c3.5 0 6.64 1.35 9 3.54 2.36-2.19 5.5-3.54 9-3.54V8c-3.5 0-6.64 1.35-9 3.54z"/>
            </svg>
        </a>
    </label>
    $ if (page.properties.("material.repo")) $
      <div class="md-nav__source">
        $source()$
      </div>
    $ endif $
    <ul class="md-nav__list" data-md-scrollfix>
        <li class="md-nav__item md-nav__item--active"><input class="md-nav__toggle md-toggle"
                                                              data-md-toggle="toc"
                                                              type="checkbox"
                                                              id="__toc">
            <label class="md-nav__link md-nav__link--active" for="__toc">
                $page.home.title$
                <span class="md-nav__icon md-icon">
                  $ if (page.properties.("material.logo.icon")) $
                    <i class="md-icon">$page.properties.("material.logo.icon")$</i>
                  $ else $
                    $ if (page.properties.("material.logo.uri")) $
                      <img src="$page.properties.("material.logo.uri")$" width="24" height="24">
                    $ else $
                      <img src="$page.base$$page.properties.("material.logo")$" width="24" height="24">
                    $endif$
                  $endif$
                </span>
            </label>
             <a href="$page.home.href$" title="$page.home.title$">
               $page.home.title$
            </a>
        </li>
    </ul>
  $page.groups$
  $page.navigation$
  $toc()$
</nav>