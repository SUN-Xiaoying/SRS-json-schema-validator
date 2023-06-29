lazy val scala212 = "2.12.17"
lazy val scala213 = "2.13.10"
lazy val scala3 = "3.2.2"

lazy val supportedScalaVersions = List(scala212, scala213, scala3)

ThisBuild / scalaVersion := scala3

val circeVersion = "0.14.5"

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "org.scalatest" %% "scalatest-flatspec" % "3.2.16" % Test,
  "commons-io" % "commons-io" % "2.11.0" % Test
)

lazy val schema = (project in file("schema"))
  .settings(name := "circe-json-schema")
  .settings(
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion
    ),
    libraryDependencies ++= testDependencies,
    crossScalaVersions := supportedScalaVersions,
    Compile / scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) if n <= 12 => List("-Ypartial-unification")
        case _                       => Nil
      }
    }
  )


lazy val root = (project in file("."))
  .dependsOn(schema)
  .settings(
    name := "json-schema-validator",
    publishArtifact := false,
    publish := {},
    publishLocal := {},
    crossScalaVersions := supportedScalaVersions
  )
