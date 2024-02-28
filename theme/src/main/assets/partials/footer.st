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
    <nav class="md-footer-nav__inner md-grid" aria-label="footer"
      $ if (page.prev.html) $
        <a href="$page.prev.href$" class="md-footer__link md-footer__link--prev" aria-label="$page.prev.title$" title="$page.prev.title$">
          <div class="md-footer__button md-icon">
            <i class="md-icon md-icon--arrow-back md-footer-nav__button"></i>
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
        <a href="$page.next.href$" class="md-footer__link md-footer__link--next" aria-label="$page.next.title$" title="$page.next.title$">
          <div class="md-footer__title">
            <span class="md-footer__direction">
                Next
            </span>
            <div class="md-ellipsis">
              $page.next.title$
            </div>
          </div>
          <div class="md-footer__button md-icon">
               <i class="md-icon md-icon--arrow-forward md-footer-nav__button"></i>
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
