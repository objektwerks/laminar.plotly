import org.scalajs.linker.interface.ModuleSplitStyle

lazy val scalaVersion = "3.7.1-RC1"

lazy val common = Defaults.coreDefaultSettings ++ Seq(
  organization := "objektwerks",
  version := "1.0.0"
)

lazy val laminar = project.in(file("laminar"))
  .enablePlugins(ScalaJSPlugin)
  .aggregate(plotly)
  .settings(common)
  .settings(
    scalaVersion := scalaVersion,
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % "17.2.1"
    )
  ).dependsOn(plotly)

lazy val plotly = project.in(file("plotly"))
.enablePlugins(ScalaJSPlugin)
.settings(common)
  .settings(
    scalaVersion := scalaVersion,
    libraryDependencies ++= Seq(
      ("org.plotly-scala" %%% "plotly-render" % "0.8.5")
      .cross(CrossVersion.for3Use2_13)
      .exclude("org.scala-js", "scalajs-dom_sjs1_2.13")
    )
  )