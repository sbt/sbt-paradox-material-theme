<footer class="md-footer">
  $ if (page.next.html || page.prev.html) $
    <div class="md-footer-nav">
      <nav class="md-footer-nav__inner md-grid">
        $ if (page.prev.html) $
          <a href="$page.prev.href$" title="$page.prev.title$" class="md-flex md-footer-nav__link md-footer-nav__link--prev" rel="prev">
            <div class="md-flex__cell md-flex__cell--shrink">
              <i class="md-icon md-icon--arrow-back md-footer-nav__button"></i>
            </div>
            <div class="md-flex__cell md-flex__cell--stretch md-footer-nav__title">
              <span class="md-flex__ellipsis">
                <span class="md-footer-nav__direction">
                  Previous
                </span>
                $page.prev.title$
              </span>
            </div>
          </a>
        $ endif $
        $ if (page.next.html) $
          <a href="$page.next.href$" title="$page.next.title$" class="md-flex md-footer-nav__link md-footer-nav__link--next" rel="next">
            <div class="md-flex__cell md-flex__cell--stretch md-footer-nav__title">
              <span class="md-flex__ellipsis">
                <span class="md-footer-nav__direction">
                  Next
                </span>
                $page.next.title$
              </span>
            </div>
            <div class="md-flex__cell md-flex__cell--shrink">
              <i class="md-icon md-icon--arrow-forward md-footer-nav__button"></i>
            </div>
          </a>
        $ endif $
      </nav>
    </div>
  $endif$
  <div class="md-footer-meta md-typeset">
    <div class="md-footer-meta__inner md-grid">
      <div class="md-footer-copyright">
        $ if (page.properties.("material.copyright")) $
          <div class="md-footer-copyright__highlight">
            $page.properties.("material.copyright")$
          </div>
        $ endif $
        $poweredby()$
      </div>
      $social()$
    </div>
  </div>
</footer>
