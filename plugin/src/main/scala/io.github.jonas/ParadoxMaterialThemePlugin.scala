package io.github.jonas.paradox.material.theme

import com.lightbend.paradox.sbt.ParadoxPlugin
import sbt._
import sbt.Keys.version

object ParadoxMaterialThemePlugin extends AutoPlugin {
  type SearchIndex = _root_.io.github.jonas.paradox.material.theme.SearchIndex
  val SearchIndex = _root_.io.github.jonas.paradox.material.theme.SearchIndex

  object autoImport {
    class ParadoxMaterialTheme()
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
      paradoxMaterialTheme := new ParadoxMaterialTheme()
    ))

}
