sys.props.get("project.version") match {
  case Some(x) => addSbtPlugin("com.github.sbt" % "sbt-paradox-material-theme" % x)
  case _       => sys.error("The system property 'project.version' is not defined.")
}

libraryDependencies += "org.jsoup" % "jsoup" % "1.23.2"
