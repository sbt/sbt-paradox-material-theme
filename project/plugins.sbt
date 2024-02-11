addSbtPlugin("com.lightbend.paradox" % "sbt-paradox"        % "0.4.4")
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme"  % "0.4.4")
addSbtPlugin("com.github.sbt"        % "sbt-site"           % "1.5.0")
addSbtPlugin("com.github.sbt"        % "sbt-ghpages"        % "0.8.0")
addSbtPlugin("com.github.sbt"        % "sbt-ci-release"     % "1.5.12")
addSbtPlugin("org.xerial.sbt"        % "sbt-sonatype"       % "2.0")
addSbtPlugin("org.scalameta"         % "sbt-scalafmt"       % "2.5.2")
addSbtPlugin("com.github.sbt"        % "sbt-github-actions" % "0.23.0")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

// This project is its own plugin :)
Compile / unmanagedSourceDirectories += baseDirectory.value.getParentFile / "plugin" / "src" / "main" / "scala"
libraryDependencies += "org.jsoup" % "jsoup"      % "1.10.3"
libraryDependencies += "io.circe" %% "circe-core" % "0.8.0"
