organization := "io.github.mikla"
name := "pillar-core"
version := "3.0.1"
scalaVersion := "2.13.1"
homepage := Some(url("https://github.com/comeara/pillar-core"))
licenses := Seq("MIT license" -> url("http://www.opensource.org/licenses/mit-license.php"))
libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.0.0",
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "3.1.0" % "test",
  "org.scalatestplus" %% "scalatestplus-mockito" % "1.0.0-M2" % "test",
  "org.slf4j" % "slf4j-simple" % "1.7.22" % "test"
)
publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
publishArtifact in Test := false
pomIncludeRepository := { _ => false }
pomExtra := (
  <scm>
    <url>git@github.com:comeara/pillar-core.git</url>
    <connection>scm:git:git@github.com:comeara/pillar-core.git</connection>
  </scm>
  <developers>
    <developer>
      <id>comeara</id>
      <name>Chris O'Meara</name>
      <url>https://github.com/comeara</url>
    </developer>
  </developers>)
