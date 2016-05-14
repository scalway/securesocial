name := "SecureSocial-parent"

version := Common.version

scalaVersion := Common.scalaVersion

lazy val coreSecureSocial =  project.in( file("module-code") ).enablePlugins(PlayScala)

lazy val scalaDemoSecureSocial = project.in( file("samples/scala/demo") ).enablePlugins(PlayScala).dependsOn(coreSecureSocial)

lazy val javaDemoSecureSocial = project.in( file("samples/java/demo") ).enablePlugins(PlayJava).dependsOn(coreSecureSocial)

lazy val rootSecureSocial = project.in( file(".") ).aggregate(coreSecureSocial, scalaDemoSecureSocial, javaDemoSecureSocial) .settings(
     aggregate in update := false
   )
   
   
resolvers += Resolver.jcenterRepo
organization := "com.scalway"
name := "securesocial"
licenses += ("Apache License Version 2.0", url("http://www.apache.org/licenses/"))
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalaVersion := "2.11.7"
crossScalaVersions := Seq("2.10.6", "2.11.7")
bintrayPackageLabels := Seq("securesocial", "fork", "play-framework")
bintrayVcsUrl := Some("git@github.com/scalway/securesocial")

