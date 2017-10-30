package io.github.jonas.paradox.material.theme

import com.lightbend.paradox.sbt.ParadoxPlugin
import sbt._
import sbt.Keys._

object ParadoxMaterialThemePlugin extends AutoPlugin {
  object autoImport {
    type ParadoxMaterialTheme = _root_.io.github.jonas.paradox.material.theme.ParadoxMaterialTheme
    val ParadoxMaterialTheme = _root_.io.github.jonas.paradox.material.theme.ParadoxMaterialTheme

    val paradoxMaterialTheme = settingKey[ParadoxMaterialTheme]("Material theme options")
  }
  import autoImport._
  import ParadoxPlugin.autoImport._

  override def requires = ParadoxPlugin
  override def trigger = noTrigger

  override def projectSettings: Seq[Setting[_]] = Def.settings(
    paradoxMaterialThemeGlobalSettings,
    paradoxMaterialThemeSettings(Compile)
  )

  def paradoxMaterialThemeGlobalSettings: Seq[Setting[_]] = Def.settings(
    version in paradoxMaterialTheme :=
      Option(ParadoxPlugin.readProperty("paradox-material-theme.properties", "version"))
        .getOrElse(sys.error("Undefined paradox-material-theme version")),
    paradoxTheme := Some("io.github.jonas" % "paradox-material-theme" % (version in paradoxMaterialTheme).value)
  )

  def paradoxMaterialThemeSettings(config: Configuration): Seq[Setting[_]] =
    inConfig(config)(Def.settings(
      paradoxMaterialTheme := ParadoxMaterialTheme(),
      paradoxProperties += ("material.theme.version" -> (version in paradoxMaterialTheme).value),
      paradoxProperties ++= paradoxMaterialTheme.value.paradoxProperties,
      mappings in paradoxMaterialTheme := Def.taskDyn {
        if (paradoxProperties.value.contains("material.search"))
          Def.task(Seq(SearchIndex.mapping(config).value))
        else
          Def.task(Seq.empty[(File, String)])
      }.value,
      mappings in paradox ++= (mappings in paradoxMaterialTheme).value
    ))

}
