package objektwerks

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("App")
class App() extends js.Object:
  def init(): Unit =
    LineChart("line-chart")
    BarChart("bar-chart")
    TimeSeriesChart("time-series-chart")