name := "SecureSocial-parent"

version := Common.version

scalaVersion := Common.scalaVersion

lazy val coreSecureSocial =  project.in( file("module-code") ).enablePlugins(PlayScala)

lazy val scalaDemoSecureSocial = project.in( file("samples/scala/demo") ).enablePlugins(PlayScala).dependsOn(coreSecureSocial)

lazy val javaDemoSecureSocial = project.in( file("samples/java/demo") ).enablePlugins(PlayJava).dependsOn(coreSecureSocial)

lazy val rootSecureSocial = project.in( file(".") ).aggregate(coreSecureSocial, scalaDemoSecureSocial, javaDemoSecureSocial) .settings(
     aggregate in update := false
   )

