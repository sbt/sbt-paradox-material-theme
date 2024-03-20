sys.props.get("project.version") match {
  case Some(x) => addSbtPlugin("com.github.sbt" % "sbt-paradox-material-theme" % x)
  case _ => sys.error("""|The system property 'project.version' is not defined.
                         |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
}

addSbtPlugin(("com.github.sbt" % "sbt-site-paradox" % "1.6.0").exclude("com.lightbend.paradox", "sbt-paradox"))
