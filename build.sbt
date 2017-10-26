lazy val root = project.in(file("."))
  .enablePlugins(ParadoxMaterialThemePlugin, GhpagesPlugin, ReleasePlugin)
  .settings(
    name := "paradox-material-theme-parent",
    addCommandAlias("validate", ";theme/publishLocal;test;plugin/scripted;makeSite"),
    publish := {},
    publishLocal := {},
    publishArtifact := false,
    releasePublishArtifactsAction := PgpKeys.publishSigned.value,
    releaseTagName := (version in ThisBuild).value,
    releaseVersionFile := target.value / "unused-version.sbt",
    releaseProcess := {
      import ReleaseTransformations._
      Seq[ReleaseStep](
        { st: State =>
          val v = (version in ThisBuild).value
          st.put(ReleaseKeys.versions, (v, v))
        },
        releaseStepTask(makeSite),
        releaseStepCommandAndRemaining("^test"),
        releaseStepCommandAndRemaining("^scripted"),
        setReleaseVersion,
        tagRelease,
        releaseStepCommandAndRemaining("^publish"),
        // FIXME: releaseStepCommand("sonatypeRelease"),
        pushChanges,
        releaseStepTask(ghpagesPushSite)
      )
    },
    ghpagesNoJekyll := true,
    mappings in makeSite ++= (mappings in (Compile, paradoxMaterialTheme)).value,
    siteSourceDirectory := (target in (Compile, paradox)).value,
    paradox in Compile := (paradox in Compile).dependsOn(publishLocal in theme).value,
    makeSite := makeSite.dependsOn(paradox in Compile).value,
    version in paradoxMaterialTheme := version.value,
    paradoxProperties in Compile ++= Map(
      "project.name" -> "Paradox Material Theme",
      "github.base_url" -> "https://github.com/jonas/paradox-material-theme"
    ),
    //#color
    paradoxMaterialTheme in Compile ~= {
      _.withColor("teal", "indigo")
    }
    //#color
    ,
    //#repository
    paradoxMaterialTheme in Compile ~= {
      _.withRepository(uri("https://github.com/jonas/paradox-material-theme"))
    }
    //#repository
    ,
    //#social
    paradoxMaterialTheme in Compile ~= {
      _.withSocial(
        uri("https://github.com/jonas"),
        uri("https://twitter.com/priorarts")
      )
    }
    //#social
    ,
    //#language
    paradoxMaterialTheme in Compile ~= {
      _.withLanguage(java.util.Locale.ENGLISH)
    }
    //#language
    ,
    //#analytics
    paradoxMaterialTheme in Compile ~= {
      _.withGoogleAnalytics("UA-107934279-1") // Remember to change this!
    }
    //#analytics
    ,
    //#copyright
    paradoxMaterialTheme in Compile ~= {
      _.withCopyright("""
        Based on <a href="https://github.com/squidfunk/mkdocs-material">MkDocs Material</a>
        by <a href="https://github.com/squidfunk">Martin Donath</a>
      """)
    }
    //#copyright
  )
  .aggregate(theme, plugin)

lazy val plugin = project.in(file("plugin"))
  .settings(
    sbtPlugin := true,
    name := "sbt-paradox-material-theme",
    crossSbtVersions := List("0.13.16", "1.0.2"),
    scalaVersion := {
      (sbtBinaryVersion in pluginCrossBuild).value match {
        case "0.13" => "2.10.6"
        case _      => "2.12.3"
      }
    },
    // fixed in https://github.com/sbt/sbt/pull/3397 (for sbt 0.13.17)
    sbtBinaryVersion in update := (sbtBinaryVersion in pluginCrossBuild).value,
    scriptedLaunchOpts += "-Dproject.version=" + version.value,
    scriptedBufferLog := false,
    publishLocal := publishLocal.dependsOn(publishLocal in theme).value,
    addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.3.1"),
    libraryDependencies += "org.jsoup" % "jsoup" % "1.10.3",
    libraryDependencies += "io.circe" %% "circe-core" % "0.8.0",
    resourceGenerators in Compile += Def.task {
      val file = (resourceManaged in Compile).value / "paradox-material-theme.properties"
      IO.write(file, s"version=${version.value}")
      Seq(file)
    }
  )

lazy val theme = project.in(file("theme"))
  .enablePlugins(ParadoxThemePlugin)
  .settings(
    name := "paradox-material-theme",
    description := "Material Design theme for Paradox",
    WebKeys.webJars in Assets := {
      val out = (WebKeys.webJars in Assets).value
      (WebKeys.webJarsDirectory in Assets).value.**(
        "*.min.js" | "*.min.css" | "lang-*.js" | "prettify.css" | "prettify.js"
      ).get.filter(_.isFile)
    },
    libraryDependencies += "org.webjars" % "prettify" % "4-Mar-2013-1" % Provided,
    libraryDependencies += "org.webjars" % "modernizr" % "2.8.3" % Provided,
    libraryDependencies +=
      Seq("animation", "base", "ripple", "rtl", "theme", "typography")
        .foldLeft("org.webjars.npm" % "material__tabs" % "0.3.1" % Provided) {
          (lib, dep) => lib.exclude("org.webjars.npm", s"material__$dep")
        }
  )

lazy val optionExamples = Def.settings(
  //#builder-api
  paradoxMaterialTheme in Compile := {
    ParadoxMaterialTheme()
      .withColor("red", "orange")
      .withLogoIcon("cloud")
      .withCopyright("Copyleft © Jonas Fonseca")
  }
  //#builder-api
  ,
  //#builder-api-v2
  paradoxMaterialTheme in Compile ~= {
    _.withColor("red", "orange")
     .withLogoIcon("cloud")
     .withCopyright("Copyleft © Jonas Fonseca")
  }
  //#builder-api-v2
  ,
  //#font
  paradoxMaterialTheme in Compile ~= {
    _.withFont("Ubuntu", "Ubuntu Mono")
  }
  //#font
  ,
  //#font-disable
  paradoxMaterialTheme in Compile ~= {
    _.withoutFont()
  }
  //#font-disable
  ,
  //#favicon
  paradoxMaterialTheme in Compile ~= {
    _.withFavicon("assets/images/favicon.png")
  }
  //#favicon
  ,
  //#logo
  paradoxMaterialTheme in Compile ~= {
    _.withLogo("assets/images/logo.png")
  }
  //#logo
  ,
  //#logo-icon
  paradoxMaterialTheme in Compile ~= {
    _.withLogoIcon("cloud")
  }
  //#logo-icon
  ,
  //#custom-stylesheet
  paradoxMaterialTheme in Compile ~= {
    _.withCustomStylesheet("assets/custom.css")
  }
  //#custom-stylesheet
  ,
  //#custom-javascript
  paradoxMaterialTheme in Compile ~= {
    _.withCustomJavaScript("assets/custom.js")
  }
  //#custom-javascript
  ,
  //#disable-search
  paradoxMaterialTheme in Compile ~= {
    _.withoutSearch()
  }
  //#disable-search
  ,
  //#search-tokenizer
  paradoxMaterialTheme in Compile ~= {
    _.withSearch(tokenizer = "[\\s\\-\\.]+")
  }
  //#search-tokenizer
)
