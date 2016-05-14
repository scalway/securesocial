name := "SecureSocial"

version := Common.version

scalaVersion := Common.scalaVersion

crossScalaVersions := Seq("2.11.8")

//PlayKeys.generateRefReverseRouter := false

libraryDependencies ++= Seq(
  cache,
  ws,
  filters,
  specs2 % "test",
  "com.typesafe.play" %% "play-mailer" % "3.0.1",
  "org.mindrot" % "jbcrypt" % "0.3m"
)

scalariformSettings

resolvers ++= Seq(
  Resolver.typesafeRepo("releases")
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

organizationName := "SecureSocial-clone"

organizationHomepage := Some(new URL("http://www.securesocial.ws"))

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

startYear := Some(2012)

description := "An authentication module for Play Framework applications supporting OAuth, OAuth2, OpenID, Username/Password and custom authentication schemes."

homepage := Some(url("http://www.securesocial.ws"))

scalacOptions := Seq("-encoding", "UTF-8", "-Xlint", "-deprecation", "-unchecked", "-feature")

// not adding -Xlint:unchecked for now, will do it once I improve the Java API
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8",  "-Xlint:-options")

resolvers += Resolver.jcenterRepo
organization := "com.scalway"
name := "securesocial"
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalaVersion := "2.11.7"
crossScalaVersions := Seq("2.10.6", "2.11.7")
bintrayPackageLabels := Seq("securesocial", "fork", "play-framework")
bintrayVcsUrl := Some("git@github.com/scalway/securesocial")

publishMavenStyle := false 

resolvers += Resolver.url(
  "raisercostin ivy resolver", url("http://dl.bintray.com/raisercostin/maven")
)(Resolver.ivyStylePatterns)

