package com.github.sbt.paradox.material.theme

import com.lightbend.paradox.sbt.ParadoxPlugin
import sbt._
import sbt.Keys._

object ParadoxMaterialThemePlugin extends AutoPlugin {
  object autoImport {
    type ParadoxMaterialTheme = _root_.com.github.sbt.paradox.material.theme.ParadoxMaterialTheme
    val ParadoxMaterialTheme = _root_.com.github.sbt.paradox.material.theme.ParadoxMaterialTheme

    val paradoxMaterialTheme = settingKey[ParadoxMaterialTheme]("Material theme options")
  }
  import autoImport._
  import ParadoxPlugin.autoImport._

  override lazy val requires = ParadoxPlugin
  override lazy val trigger = noTrigger

  override lazy val projectSettings: Seq[Setting[_]] = Def.settings(
    paradoxMaterialThemeGlobalSettings,
    paradoxMaterialThemeSettings
  )

  lazy val paradoxMaterialThemeGlobalSettings: Seq[Setting[_]] = Def.settings(
    paradoxMaterialTheme / version :=
      Option(ParadoxPlugin.readProperty("paradox-material-theme.properties", "version"))
        .getOrElse(sys.error("Undefined paradox-material-theme version")),
    paradoxTheme := Some("com.github.sbt" % "paradox-material-theme" % (paradoxMaterialTheme / version).value)
  )

  lazy val paradoxMaterialThemeSettings: Seq[Setting[_]] = Def.settings(
    Compile / paradoxMaterialTheme := ParadoxMaterialTheme(),
    Compile / paradoxProperties += ("material.theme.version" -> (paradoxMaterialTheme / version).value),
    Compile / paradoxProperties ++= (Compile / paradoxMaterialTheme).value.paradoxProperties,
    Compile / paradoxMaterialTheme / mappings := Def.taskDyn {
      if ((Compile / paradoxProperties).value.contains("material.search"))
        Def.task(Seq(SearchIndex.mapping(Compile).value))
      else
        Def.task(Seq.empty[(File, String)])
    }.value,
    Compile / paradox / mappings ++= (Compile / paradoxMaterialTheme / mappings).value
  )

}
