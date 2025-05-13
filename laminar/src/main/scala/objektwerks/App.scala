package objektwerks

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("App")
object App:
  def main(args: Array[String]): Unit =
    LineChart("line-chart")
    BarChart("bar-chart")
    TimeSeriesChart("time-series-chart")