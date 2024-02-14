addSbtPlugin("com.lightbend.paradox" % "sbt-paradox"       % "0.10.6")
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox-theme" % "0.10.6")

sys.props.get("project.version") match {
  case Some(x) => addSbtPlugin("com.github.sbt" % "sbt-paradox-material-theme" % x)
  case _ => sys.error("""|The system property 'project.version' is not defined.
                               |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
}
