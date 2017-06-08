lazy val root = (project in file(".")).settings(
  name := "ScalaLearn",
  version := "0.1.0",
  scalaVersion := "2.11.8"
)

val nd4jVersion = "0.8.0"

libraryDependencies ++= Seq(
  "org.nd4j" % "nd4s_2.11" % nd4jVersion,
  "org.nd4j" % "nd4j-native-platform" % nd4jVersion,
  "org.slf4j" % "slf4j-simple" % "1.7.21"
)
