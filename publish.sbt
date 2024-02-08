val repo = new {
  val org = "sbt"
  val name = "sbt-paradox-material-theme"
  val path = org + "/" + name
}

def versionFmt(out: sbtdynver.GitDescribeOutput): String = {
  val snapshotSuffix =
    if (out.isSnapshot()) "-SNAPSHOT"
    else ""
  out.ref.dropPrefix + snapshotSuffix
}

def fallbackVersion(d: java.util.Date): String = s"HEAD-${sbtdynver.DynVer timestamp d}"

inThisBuild(
  Def.settings(
    organization := "com.github.sbt",
    licenses += "MIT" -> url("https://github.com/sbt/sbt-paradox-material-theme/blob/master/LICENSE"),
    homepage := Some(url(s"https://${repo.org}.github.io/${repo.name}")),
    scmInfo := Some(
      ScmInfo(
        url(s"https://github.com/${repo.path}"),
        s"scm:git:git@github.com:${repo.path}.git"
      )
    ),
    developers := List(
      Developer("jonas", "Jonas Fonseca", "jonas.fonseca@gmail.com", url("https://github.com/jonas")),
      Developer(
        "sbt-paradox-material-theme",
        "Sbt Paradox Material Theme Contributors",
        "",
        url("https://github.com/sbt/sbt-multi-jvm/graphs/contributors")
      )
    ),
    dynverSonatypeSnapshots := true,
    git.useGitDescribe := true,
    git.remoteRepo := s"git@github.com:${repo.path}.git",
    // So that publishLocal doesn't continuously create new versions
    version := dynverGitDescribeOutput.value.mkVersion(versionFmt, fallbackVersion(dynverCurrentDate.value)),
    dynver := {
      val d = new java.util.Date
      sbtdynver.DynVer.getGitDescribeOutput(d).mkVersion(versionFmt, fallbackVersion(d))
    }
  )
)
