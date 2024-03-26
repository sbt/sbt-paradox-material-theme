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
<footer class="md-footer">
  $ if (page.next.html || page.prev.html) $
    <nav class="md-footer__inner md-grid" aria-label="Footer">
      $ if (page.prev.html) $
        <a href="$page.prev.href$" class="md-footer__link md-footer__link--prev" aria-label="$page.prev.title$">
          <div class="md-footer__button md-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M20 11v2H8l5.5 5.5-1.42 1.42L4.16 12l7.92-7.92L13.5 5.5 8 11h12Z"/></svg>
          </div>
          <div class="md-footer__title">
            <span class="md-footer__direction">
              Previous
            </span>
            <div class="md-ellipsis">
              $page.prev.title$
            </div>
          </div>
        </a>
      $ endif $
      $ if (page.next.html) $
        <a href="$page.next.href$" class="md-footer__link md-footer__link--next" aria-label="$page.next.title$">
          <div class="md-footer__title">
            <span class="md-footer__direction">
              Next
            </span>
            <div class="md-ellipsis">
              $page.next.title$
            </div>
          </div>
          <div class="md-footer__button md-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M4 11v2h12l-5.5 5.5 1.42 1.42L19.84 12l-7.92-7.92L10.5 5.5 16 11H4Z"/></svg>
          </div>
        </a>
      $ endif $
    </nav>
  $endif$
  <div class="md-footer-meta md-typeset">
    <div class="md-footer-meta__inner md-grid">
      $copyright()$
      $social()$
    </div>
  </div>
</footer>
