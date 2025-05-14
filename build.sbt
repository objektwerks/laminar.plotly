lazy val laminarVersion = "17.2.1"
lazy val plotlyVersion = "0.8.5"

lazy val common = Defaults.coreDefaultSettings ++ Seq(
  organization := "objektwerks",
  version := "1.0.0",
  scalaVersion :=  "3.7.1-RC1"
)

lazy val laminar = project.in(file("laminar"))
  .enablePlugins(ScalaJSPlugin)
  .settings(common)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % laminarVersion
    )
  ).dependsOn(plotly)

lazy val plotly = project.in(file("plotly"))
.enablePlugins(ScalaJSPlugin)
.settings(common)
  .settings(
    libraryDependencies ++= Seq(
      ("org.plotly-scala" %%% "plotly-render" % plotlyVersion)
      .cross(CrossVersion.for3Use2_13)
      .exclude("org.scala-js", "scalajs-dom_sjs1_2.13")
    )
  )

  lazy val copyFastOptMainJs = taskKey[Unit]("Copy laminar main.js to root main.js.")
  copyMainJs := {
    import java.nio.file.*
    
    val source: Path = Paths.get("./laminar/target/scala-3.7.1-RC1/laminar-fastopt/main.js")
    val target: Path = Paths.get("./main.js")
  
    println(s"[copyMainJs] source: $source")
    println(s"[copyMainJs] target: $target")
  
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)
  }

  lazy val copyFullOptMainJs = taskKey[Unit]("Copy laminar main.js to root main.js.")
  copyMainJs := {
    import java.nio.file.*
    
    val source: Path = Paths.get("./laminar/target/scala-3.7.1-RC1/laminar-opt/main.js")
    val target: Path = Paths.get("./main.js")
  
    println(s"[copyMainJs] source: $source")
    println(s"[copyMainJs] target: $target")
  
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)
  }