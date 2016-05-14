// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % System.getProperty("play.version", "2.5.1"))

// Add Scalariform
addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

// PGP signing
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")


resolvers += Resolver.url(
    "bintray-sbt-plugin-releases", url("http://dl.bintray.com/content/sbt/sbt-plugin-releases")
  )(Resolver.ivyStylePatterns)
  
addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")
