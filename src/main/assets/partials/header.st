<header class="md-header" data-md-component="header">
  <nav class="md-header-nav md-grid">
    <div class="md-flex">
      <div class="md-flex__cell md-flex__cell--shrink">
        <a href="$page.home.href$" title="$page.home.title$" class="md-header-nav__button md-logo">
          $ if (page.properties.("material.logo.icon")) $
            <i class="md-icon">$page.properties.("material.logo.icon")$</i>
          $ elseif (page.properties.("material.logo")) $
            <img src="$page.base$$page.properties.("material.logo")$" width="24" height="24">
          $ else $
            <i class="md-icon md-icon--home"></i>
          $endif$
        </a>
      </div>
      <div class="md-flex__cell md-flex__cell--shrink">
        <label class="md-icon md-icon--menu md-header-nav__button" for="drawer"></label>
      </div>
      <div class="md-flex__cell md-flex__cell--stretch">
        <span class="md-flex__ellipsis md-header-nav__title">
          $! FIXME: breadcrumbs in the title?
          {% if page %}
            {% for parent in page.ancestors %}
              <span class="md-header-nav__parent">
                {{ parent.title }}
              </span>
            {% endfor %}
          {% endif %}
          !$
          $page.title$
        </span>
      </div>
      <div class="md-flex__cell md-flex__cell--shrink" style="display: none">
        <label class="md-icon md-icon--search md-header-nav__button" for="search"></label>
        $search()$
      </div>
      $ if (page.properties.("material.repo")) $
        <div class="md-flex__cell md-flex__cell--shrink">
          <div class="md-header-nav__source">
            $source()$
          </div>
        </div>
      $ endif $
    </div>
  </nav>
</header>
