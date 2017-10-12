val repo = new {
  val org = "jonas"
  val name = "paradox-material-theme"
  val path = org + "/" + name
}

homepage := Some(url(s"https://${repo.org}.github.io/${repo.name}"))
scmInfo := Some(
  ScmInfo(
    url(s"https://github.com/${repo.path}"),
    s"scm:git:git@github.com:${repo.path}.git"
  )
)
developers := List(
  Developer("jonas", "Jonas Fonseca", "jonas.fonseca@gmail.com", url("https://github.com/jonas"))
)

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
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
).toSeq

enablePlugins(GitPlugin)
versionWithGit
git.useGitDescribe := true
git.remoteRepo := s"git@github.com:${repo.path}.git"

enablePlugins(GhpagesPlugin)
ghpagesNoJekyll := true

enablePlugins(ReleasePlugin)
releasePublishArtifactsAction := PgpKeys.publishSigned.value
releaseTagName := (version in ThisBuild).value
releaseVersionFile := target.value / "unused-version.sbt"
releaseProcess := {
  import ReleaseTransformations._
  Seq[ReleaseStep](
    checkSnapshotDependencies,
    { st: State =>
      val v = (version in ThisBuild).value
      st.put(ReleaseKeys.versions, (v, v))
    },
    releaseStepTask(makeSite),
    setReleaseVersion,
    tagRelease,
    publishArtifacts,
    pushChanges,
    releaseStepTask(ghpagesPushSite)
  )
}
