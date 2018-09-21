# Tabbed snippets

## Library dependencies

Example of the [`@@dependency` directive][dependency]:

 [dependency]: http://developer.lightbend.com/docs/paradox/current/directives/dependencies.html

@@dependency[sbt,Maven,Gradle] {
  group="com.typesafe.akka"
  artifact="akka-http_2.12"
  version="10.0.10"
}

## Snippet inclusion

Multiple snippets [included] from files:

 [included]: http://developer.lightbend.com/docs/paradox/current/directives/snippets.html

Favicon
:  @@ snip [build.sbt]($root$/build.sbt) { #favicon }

Repository
:  @@ snip [build.sbt]($root$/build.sbt) { #repository }

Copyright notice
:  @@ snip [build.sbt]($root$/build.sbt) { #copyright }

Font
:  @@ snip [build.sbt]($root$/build.sbt) { #font }
