addSbtPlugin("com.lightbend.paradox" % "sbt-paradox"        % "0.11.0")
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme"  % "0.11.0")
addSbtPlugin("com.github.sbt"        % "sbt-web"            % "1.6.0-M4")
addSbtPlugin("com.github.sbt"        % "sbt2-compat"        % "0.2.0")
addSbtPlugin(("com.github.sbt"       % "sbt-site-paradox"   % "1.8.0").exclude("com.lightbend.paradox", "sbt-paradox"))
addSbtPlugin("com.github.sbt"        % "sbt-ghpages"        % "0.10.0")
addSbtPlugin("com.github.sbt"        % "sbt-ci-release"     % "1.12.1")
addSbtPlugin("org.scalameta"         % "sbt-scalafmt"       % "2.6.2")
addSbtPlugin("com.github.sbt"        % "sbt-github-actions" % "0.32.1")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

// This project is its own plugin :)
Compile / unmanagedSourceDirectories += baseDirectory.value.getParentFile / "plugin" / "src" / "main" / "scala"
libraryDependencies += "org.jsoup" % "jsoup"      % "1.23.2"
libraryDependencies += "io.circe" %% "circe-core" % "0.14.16"
