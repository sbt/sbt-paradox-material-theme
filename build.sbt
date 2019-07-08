lazy val root = project("paradox-material-theme-parent", file("."))
  .enablePlugins(ParadoxMaterialThemePlugin, GhpagesPlugin, ReleasePlugin)
  .settings(
    addCommandAlias("verify", "; ^sbt-paradox-material-theme/scripted ; makeSite"),
    publish / skip := true,
    releasePublishArtifactsAction := PgpKeys.publishSigned.value,
    releaseTagName := (ThisBuild / version).value,
    releaseVersionFile := target.value / "unused-version.sbt",
    releaseProcess := {
      import ReleaseTransformations._
      Seq[ReleaseStep](
        { st: State =>
          val v = (ThisBuild / version).value
          st.put(ReleaseKeys.versions, (v, v))
        },
        releaseStepTask(makeSite),
        releaseStepCommandAndRemaining("^test"),
        releaseStepCommandAndRemaining("^sbt-paradox-material-theme/scripted"),
        setReleaseVersion,
        tagRelease,
        releaseStepCommandAndRemaining("paradox-material-theme/publishSigned"),
        releaseStepCommandAndRemaining("^sbt-paradox-material-theme/publishSigned"),
        // FIXME: releaseStepCommand("sonatypeRelease"),
        pushChanges,
        releaseStepTask(ghpagesPushSite)
      )
    },
    ghpagesNoJekyll := true,
    makeSite / includeFilter := "*.html" | "*.css" | "*.png" | "*.png" | "*.js" | "*.woff" | "*.woff2" | "*.ttf",
    makeSite / mappings ++= (Compile / paradoxMaterialTheme / mappings).value,
    siteSourceDirectory := (Compile / paradox / target).value,
    Compile / paradox := (Compile / paradox).dependsOn(theme / publishLocal).value,
    Compile / paradoxNavigationDepth := 3,
    makeSite := makeSite.dependsOn(Compile / paradox).value,
    paradoxMaterialTheme / version := version.value,
    Compile / paradoxProperties ++= Map(
      "project.name" -> "Paradox Material Theme",
      "github.base_url" -> "https://github.com/jonas/paradox-material-theme"
    ),
    //#color
    Compile / paradoxMaterialTheme ~= {
      _.withColor("teal", "indigo")
    }
    //#color
    ,
    //#repository
    Compile / paradoxMaterialTheme ~= {
      _.withRepository(uri("https://github.com/jonas/paradox-material-theme"))
    }
    //#repository
    ,
    //#social
    Compile / paradoxMaterialTheme ~= {
      _.withSocial(
        uri("https://github.com/jonas"),
        uri("https://twitter.com/priorarts")
      )
    }
    //#social
    ,
    //#language
    Compile / paradoxMaterialTheme ~= {
      _.withLanguage(java.util.Locale.ENGLISH)
    }
    //#language
    ,
    //#analytics
    Compile / paradoxMaterialTheme ~= {
      _.withGoogleAnalytics("UA-107934279-1") // Remember to change this!
    }
    //#analytics
    ,
    //#copyright
    Compile / paradoxMaterialTheme ~= {
      _.withCopyright("""
        Based on <a href="https://github.com/squidfunk/mkdocs-material">MkDocs Material</a>
        by <a href="https://github.com/squidfunk">Martin Donath</a>
      """)
    }
    //#copyright
  )
  .aggregate(theme, plugin)

lazy val plugin = project("sbt-paradox-material-theme", file("plugin"))
  .enablePlugins(ScriptedPlugin)
  .settings(
    sbtPlugin := true,
    previewSite := {},
    scriptedLaunchOpts += "-Dproject.version=" + version.value,
    scriptedBufferLog := false,
    publishLocal := publishLocal.dependsOn(theme / publishLocal).value,
    addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.4.4"),
    libraryDependencies += "org.jsoup" % "jsoup" % "1.10.3",
    libraryDependencies += "io.circe" %% "circe-core" % "0.9.3",
    Compile / resourceGenerators += Def.task {
      val file = (Compile / resourceManaged).value / "paradox-material-theme.properties"
      IO.write(file, s"version=${version.value}")
      Seq(file)
    }
  )

lazy val theme = project("paradox-material-theme", file("theme"))
  .enablePlugins(ParadoxThemePlugin)
  .settings(
    description := "Material Design theme for Paradox",
    Assets / WebKeys.webJars := {
      val out = (Assets / WebKeys.webJars).value
      (Assets / WebKeys.webJarsDirectory).value.**(
        "*.min.js" | "*.min.css" | "lang-*.js" | "prettify.css" | "prettify.js"
      ).get.filter(_.isFile)
    },
    previewSite := {},
    libraryDependencies += "org.webjars" % "prettify" % "4-Mar-2013-1" % Provided,
    libraryDependencies +=
      Seq("animation", "base", "ripple", "rtl", "theme", "typography")
        .foldLeft("org.webjars.npm" % "material__tabs" % "0.37.1" % Provided) {
          (lib, dep) => lib.exclude("org.webjars.npm", s"material__$dep")
        }
  )

lazy val optionExamples = Def.settings(
  //#builder-api
  Compile / paradoxMaterialTheme := {
    ParadoxMaterialTheme()
      .withColor("red", "orange")
      .withLogoIcon("cloud")
      .withCopyright("Copyleft © Jonas Fonseca")
  }
  //#builder-api
  ,
  //#builder-api-v2
  Compile / paradoxMaterialTheme ~= {
    _.withColor("red", "orange")
     .withLogoIcon("cloud")
     .withCopyright("Copyleft © Jonas Fonseca")
  }
  //#builder-api-v2
  ,
  //#font
  Compile / paradoxMaterialTheme ~= {
    _.withFont("Ubuntu", "Ubuntu Mono")
  }
  //#font
  ,
  //#font-disable
  Compile / paradoxMaterialTheme ~= {
    _.withoutFont()
  }
  //#font-disable
  ,
  //#favicon
  Compile / paradoxMaterialTheme ~= {
    _.withFavicon("assets/images/favicon.png")
  }
  //#favicon
  ,
  //#logo
  Compile / paradoxMaterialTheme ~= {
    _.withLogo("assets/images/logo.png")
  }
  //#logo
  ,
  //#logo-icon
  Compile / paradoxMaterialTheme ~= {
    _.withLogoIcon("cloud")
  }
  //#logo-icon
  ,
  //#logo-uri
  Compile / paradoxMaterialTheme ~= {
    _.withLogoUri(uri("https://example.org/logo.png"))
  }
  //#logo-uri
  ,
  //#custom-stylesheet
  Compile / paradoxMaterialTheme ~= {
    _.withCustomStylesheet("assets/custom.css")
  }
  //#custom-stylesheet
  ,
  //#custom-javascript
  Compile / paradoxMaterialTheme ~= {
    _.withCustomJavaScript("assets/custom.js")
  }
  //#custom-javascript
  ,
  //#disable-search
  Compile / paradoxMaterialTheme ~= {
    _.withoutSearch()
  }
  //#disable-search
  ,
  //#search-tokenizer
  Compile / paradoxMaterialTheme ~= {
    _.withSearch(tokenizer = "[\\s\\-\\.]+")
  }
  //#search-tokenizer
)

def project(id: String, base: File): Project = {
  Project(id = id, base = base)
    .settings(
      crossSbtVersions := Seq("0.13.18", "1.0.4"),
      scalaVersion := {
        (pluginCrossBuild / sbtBinaryVersion).value match {
          case "0.13" => "2.10.7"
          case _      => "2.12.8"
        }
      }
  )
}
