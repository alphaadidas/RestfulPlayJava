import play.PlayJava

name := """RestfulPlayJava"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  javaWs,
  "com.wordnik" %% "swagger-play2" % "1.3.10",
  "com.wordnik" %% "swagger-play2-utils" % "1.3.10",
  "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final",
  "org.hibernate" % "hibernate-core" % "4.1.9.Final",
  "org.hibernate.javax.persistence" % "hibernate-jpa-2.0-api" % "1.0.1.Final",
  "commons-io" % "commons-io" % "1.3.2",
  "org.springframework" % "spring-context" % "3.1.2.RELEASE",
  "org.springframework" % "spring-orm" % "3.1.2.RELEASE",
  "org.springframework" % "spring-jdbc" % "3.1.2.RELEASE",
  "org.springframework" % "spring-tx" % "3.1.2.RELEASE",
  "com.h2database" % "h2" % "1.3.175",
  "org.drools" % "drools-core" % "6.0.1.Final",
  "org.drools" % "knowledge-api" % "6.0.1.Final",
  "org.drools" % "drools-compiler" % "6.0.1.Final"
)

