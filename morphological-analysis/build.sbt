name := "morphological-analysis"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++=Seq("Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika",
  "Spark Project ML Library" at "https://mvnrepository.com/artifact/org.apache.spark/spark-mllib_2.10",
  "Artima Maven Repository" at "http://repo.artima.com/releases",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= Seq( "org.atilika.kuromoji" % "kuromoji" % "0.7.7" ,
 // "org.apache.spark" % "spark-mllib_2.10" % "1.0.0",
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.scalanlp" %% "breeze" % "0.12",
  "org.scalanlp" %% "breeze-viz" % "0.12",
  "com.typesafe" % "config" % "1.3.0"
)