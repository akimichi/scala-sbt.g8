import sbt._
import sbt.Keys._

import org.ensime.sbt.Plugin.Settings.ensimeConfig
import org.ensime.sbt.util.SExp._
import java.io.{PrintWriter}

object ScalaProjectBuild extends Build {

  lazy val laboProject = Project(
    id = "scala-project",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "A Scala Project",
      organization := "labo",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2",
      // add other settings here
      /** scalacOptions
       *  -unchecked
       *  -deprecation
       *  -Xprint:typer 暗黙変換の情報を表示する
       *  -Xcheckinit   継承関係における予測しがたいスーパークラスの初期化をチェックする(c.f. Scala for the Impatient,p.93)
       */
      scalacOptions ++= Seq("-unchecked", "-deprecation","-Xcheckinit"),
      resolvers ++= Seq("Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
                        "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                        "releases"  at "http://oss.sonatype.org/content/repositories/releases",
                        "repo.novus rels" at "http://repo.novus.com/releases/",
                        "repo.novus snaps" at "http://repo.novus.com/snapshots/"),
	  libraryDependencies ++= Seq (
		"com.typesafe.akka" % "akka-actor" % "2.0.4",
		"com.typesafe.akka" % "akka-testkit" % "2.0.4",
        "junit" % "junit" % "4.10" % "test",
        "com.novocode" % "junit-interface" % "0.10-M2" % "test",
        "org.scalatest" %% "scalatest" % "1.7.1" % "test",
        "org.scalacheck" %% "scalacheck" % "1.9" % "test",
        "org.specs2" %% "specs2" % "1.12.1" % "test",
        "org.scalaz" %% "scalaz-core" % "6.0.4",
        "org.scalaj" %% "scalaj-time" % "0.6"
      ),
      shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " },
	  /* 以下は sbt console の起動時に実行される */
      initialCommands in console := {"""
        scala.tools.nsc.interpreter.replProps.power.enable
        import System.{currentTimeMillis => now}
        def time[T](f: => T): T = {
          val start = now
          try { f } finally { println("Elapsed: " + (now - start)/1000.0 + " s") }
        }
        import scala.sys.process._
        def find(dir:String = ".", file:String ="*.scala") =
          Seq("find", dir, "-type","f", "-name",file) 
        def grep(pattern:String) =
          Process("xargs grep -ni %s".format(pattern))
        println("Usage: find() #| grep(\"pattern\") ")
        """}
    )
  )
}
