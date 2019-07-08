addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.6.0")
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme" % "0.6.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "1.4.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.6.3")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.11")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2-1")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.5")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

// This project is its own plugin :)
unmanagedSourceDirectories in Compile += baseDirectory.value.getParentFile / "plugin" / "src" / "main" / "scala"
libraryDependencies += "org.jsoup" % "jsoup" % "1.12.1"
libraryDependencies += "io.circe" %% "circe-core" % "0.11.1"
