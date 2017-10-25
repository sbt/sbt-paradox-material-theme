val repo = new {
  val org = "jonas"
  val name = "paradox-material-theme"
  val path = org + "/" + name
}

inThisBuild(Def.settings(
  organization := "io.github.jonas",
  licenses += "MIT" -> url("https://github.com/jonas/paradox-material-theme/blob/master/LICENSE"),
  homepage := Some(url(s"https://${repo.org}.github.io/${repo.name}")),
  scmInfo := Some(
    ScmInfo(
      url(s"https://github.com/${repo.path}"),
      s"scm:git:git@github.com:${repo.path}.git"
    )
  ),
  developers := List(
    Developer("jonas", "Jonas Fonseca", "jonas.fonseca@gmail.com", url("https://github.com/jonas"))
  ),
  // Workaround NPE when publishing: https://github.com/sbt/sbt/issues/3519
  updateOptions := updateOptions.value.withGigahorse(false),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  credentials ++= (
    for {
      username <- Option(System.getenv().get("SONATYPE_USERNAME"))
      password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
    } yield Credentials(
      "Sonatype Nexus Repository Manager",
      "oss.sonatype.org",
      username,
      password
    )
  ).toSeq,
  versionWithGit,
  git.useGitDescribe := true,
  git.remoteRepo := s"git@github.com:${repo.path}.git"
))
