val repo = new {
  val org = "sbt"
  val name = "sbt-paradox-material-theme"
  val path = org + "/" + name
}

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
    githubWorkflowBuild := Seq(WorkflowStep.Sbt(List("test", "sbt-paradox-material-theme/scripted", "makeSite"))),
    ThisBuild / githubWorkflowBuildPostamble += WorkflowStep.Run(
      commands = List("""rm -rf "$HOME/.ivy2/local""""),
      name = Some("Clean up Ivy Local repo")
    ),
    githubWorkflowTargetTags ++= Seq("v*"),
    githubWorkflowPublishTargetBranches :=
      Seq(
        RefPredicate.StartsWith(Ref.Tag("v")),
        RefPredicate.Equals(Ref.Branch("main"))
      ),
    githubWorkflowPublish := Seq(
      WorkflowStep.Sbt(
        commands = List("ci-release"),
        name = Some("Publish project"),
        env = Map(
          "PGP_PASSPHRASE" -> "${{ secrets.PGP_PASSPHRASE }}",
          "PGP_SECRET" -> "${{ secrets.PGP_SECRET }}",
          "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
          "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}"
        )
      )
    ),
    githubWorkflowOSes := Seq("ubuntu-latest", "macos-latest", "windows-latest"),
    githubWorkflowJavaVersions := Seq(
      JavaSpec.temurin("8")
    ),
    githubWorkflowBuildMatrixExclusions += MatrixExclude(Map("java" -> "temurin@8", "os" -> "macos-latest"))
  )
)
