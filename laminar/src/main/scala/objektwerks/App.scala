package objektwerks

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("App")
object App:
  @JSExport
  def init(): Unit =
    LineChart("line-chart")
    BarChart("bar-chart")
    TimeSeriesChart("time-series-chart")