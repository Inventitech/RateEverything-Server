import sbt._
import Keys._
import PlayProject._


object ApplicationBuild extends Build {

    val appName         = "rateeverything-server"
    val appVersion      = "1.0-SNAPSHOT"

    val ssDependencies = Seq(
      // Add your project dependencies here,
      "com.typesafe" %% "play-plugins-util" % "2.0.1",
      "org.mindrot" % "jbcrypt" % "0.3m"
    )
 
    val secureSocial = PlayProject(
    	"securesocial", appVersion, ssDependencies, mainLang = SCALA, path = file("modules/securesocial")
    ).settings(
      resolvers ++= Seq(
        "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
      )
    )

    val appDependencies = Seq(
      "com.restfb" % "restfb" % "1.6.9"
    )
    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        resolvers ++= Seq( 
            "Maven Central" at "http://repo1.maven.org/maven2/org/"
        )
    ).dependsOn(secureSocial).aggregate(secureSocial)

}
