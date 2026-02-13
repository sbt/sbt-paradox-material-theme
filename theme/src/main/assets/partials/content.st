$ if (page.source_url) $
  <a href="$page.source_url$" title="Edit this page" class="md-content__button md-icon">
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M10 20H6V4h7v5h5v3.1l2-2V8l-6-6H6c-1.1 0-2 .9-2 2v16c0 1.1.9 2 2 2h4v-2m10.2-7c.1 0 .3.1.4.2l1.3 1.3c.2.2.2.6 0 .8l-1 1-2.1-2.1 1-1c.1-.1.2-.2.4-.2m0 3.9L14.1 23H12v-2.1l6.1-6.1 2.1 2.1Z"></path></svg>
  </a>
$ endif $

<div class="md-content__searchable">
  $page.content$
</div>

<div class="print-only">
  <span class="md-source-file md-version">
    $page.properties.("project.version.short")$
  </span>
</div>
