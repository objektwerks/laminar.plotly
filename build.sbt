import org.scalajs.linker.interface.ModuleSplitStyle

lazy val common = Defaults.coreDefaultSettings ++ Seq(
  organization := "objektwerks",
  version := "1.0.0"
)

lazy val laminar = project.in(file("laminar"))
  .enablePlugins(ScalaJSPlugin)
  .settings(common)
  .settings(
    scalaVersion := "3.7.1-RC1",
    mainClass := Some("objektwerks.App"),
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % "17.2.1"
    ),
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("objektwerks")))
    }
  ).dependsOn(plotly)

lazy val plotly = project.in(file("plotly"))
.enablePlugins(ScalaJSPlugin)
.settings(common)
  .settings(
    scalaVersion := "3.7.1-RC1",
    libraryDependencies ++= Seq(
      ("org.plotly-scala" %%% "plotly-render" % "0.8.5")
      .cross(CrossVersion.for3Use2_13)
      .exclude("org.scala-js", "scalajs-dom_sjs1_2.13")
    )
  )