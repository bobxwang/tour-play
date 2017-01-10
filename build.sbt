name := "SPlay"

version := "1.0"

scalaVersion := "2.11.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "3.2.0"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.38"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "2.0.2"
  //  , "com.typesafe.play" %% "play-slick-evolutions" % "2.0.2"
  , "com.typesafe.slick" %% "slick-codegen" % "3.1.0"
)

libraryDependencies ++= Seq(
  cache
  , jdbc
  , ws
)

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

// 解决view找不到的问题
sourceDirectories in (Compile, TwirlKeys.compileTemplates) := (unmanagedSourceDirectories in Compile).value

