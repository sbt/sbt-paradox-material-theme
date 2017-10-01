<nav class="md-nav md-nav--primary" data-md-level="0" style="visibility: hidden">
  <label class="md-nav__title md-nav__title--site" for="drawer">
    <div class="md-nav__button md-logo">
      $ if (page.properties.("material.logo.icon")) $
        <i class="md-icon">$page.properties.("material.logo.icon")$</i>
      $ elseif (page.properties.("material.logo")) $
        <img src="$page.base$$page.properties.("material.logo")$" width="24" height="24">
      $ else $
        <i class="md-icon md-icon--home"></i>
      $endif$
    </div>
    <a href="$page.home.href$" title="$page.home.title$">
      $page.home.title$
    </a>
  </label>
  <div class="md-nav__source">
    <div class="md-source__repository" title="Version">
      $page.properties.("project.version.short")$
    </div>
  </div>
  $ if (page.properties.("material.repo")) $
    <div class="md-nav__source">
      $source()$
    </div>
  $ endif $
  $page.groups$
  $page.navigation$
  $toc()$
</nav>
