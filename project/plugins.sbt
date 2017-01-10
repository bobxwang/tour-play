logLevel := Level.Warn

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.0")

resolvers += Resolver.url("https://github.com/jrudolph/sbt-dependency-graph.git")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

resolvers += Resolver.url("https://github.com/sbt/sbt-assembly.git")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.1")