lazy val laminarVersion = "17.2.1"
lazy val plotlyVersion = "0.8.5"
lazy val scalaDirectory = "scala-3.7.1-RC1"

lazy val common = Defaults.coreDefaultSettings ++ Seq(
  organization := "objektwerks",
  version := "3.0.0",
  scalaVersion := "3.7.1-RC1"
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
  copyFastOptMainJs := {
    import java.nio.file.*
    
    val mainJsSource = Paths.get(s"./laminar/target/${scalaDirectory}/laminar-fastopt/main.js")
    val mainJsTarget = Paths.get("./main.js")
  
    println(s"[copyFastOptMainJs] main.js source: $mainJsSource")
    println(s"[copyFastOptMainJs] main.js target: $mainJsTarget")

    val mainJsMapSource = Paths.get(s"./laminar/target/${scalaDirectory}/laminar-fastopt/main.js.map")
    val mainJsMapTarget = Paths.get("./main.js.map")
  
    println(s"[copyFastOptMainJs] main.js.map source: $mainJsMapSource")
    println(s"[copyFastOptMainJs] main.js.map target: $mainJsMapTarget")
  
    Files.copy(mainJsSource, mainJsTarget, StandardCopyOption.REPLACE_EXISTING)
    Files.copy(mainJsMapSource, mainJsMapTarget, StandardCopyOption.REPLACE_EXISTING)
  }

  lazy val copyFullOptMainJs = taskKey[Unit]("Copy laminar main.js to root main.js.")
  copyFullOptMainJs := {
    import java.nio.file.*
    
    val source = Paths.get(s"./laminar/target/${scalaDirectory}/laminar-opt/main.js")
    val target = Paths.get("./main.js")
  
    println(s"[copyFullOptMainJs] source: $source")
    println(s"[copyFullOptMainJs] target: $target")
  
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)
  }