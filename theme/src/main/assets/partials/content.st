<div class="md-content__searchable">
  $page.content$
</div>

$ if (page.source_url) $
  <div>
    <a href="$page.source_url$" title="Edit this page" class="md-source-file md-edit">
      Edit this page
    </a>
  </div>
$ endif $
<div class="print-only">
  <span class="md-source-file md-version">
    $page.properties.("project.version.short")$
  </span>
</div>