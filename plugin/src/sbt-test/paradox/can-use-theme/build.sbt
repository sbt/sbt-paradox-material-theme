name := "test"

//#enable-plugin
enablePlugins(ParadoxMaterialThemePlugin)
//#enable-plugin

//#enable-search
paradoxProperties in Compile ++= Map(
  "material.search" -> "true"
)
//#enable-search

//#add-search-index
mappings in (Compile, paradox) +=
  ParadoxMaterialThemePlugin.SearchIndex.mapping(Compile).value
//#add-search-index

def fileContains(file: File, texts: String*) = {
  assert(file.exists, s"${file.getAbsolutePath} did not exist")
  val content = IO.readLines(file)
  for (text <- texts)
    assert(
      content.exists(_.contains(text)),
      s"Did not find '$text' in ${file.getName}:\n${content.mkString("\n")}"
    )
}

TaskKey[Unit]("checkContent") := {
  val dest = (target in (Compile, paradox)).value

  fileContains(
    dest / "index.html",
    "Paradox Site", "Nicely themed", "mkdocs-material"
  )

  fileContains(
    dest / "mkdocs" / "search_index.json",
    "Paradox Site", "Nicely themed"
  )
}
