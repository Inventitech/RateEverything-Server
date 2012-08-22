import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "rateeverything-server"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
 		"com.google.code.gson" % "gson" % "2.2.2"
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
