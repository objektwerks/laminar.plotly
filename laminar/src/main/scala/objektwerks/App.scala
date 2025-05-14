package objektwerks

import com.raquo.laminar.api.L.{*, given}

import org.scalajs.dom

@main def run: Unit =
  val barChartId = "bar-chart"
  val lineChartId = "line-chart"
  val timeSeriesChartId = "time-series-chart"

  val container = dom.document.querySelector("#container")

  val plots = div(
    div( idAttr(barChartId) ),
    div( idAttr(lineChartId) ),
    div( idAttr(timeSeriesChartId) )
  )
   
  render(
    container = container,
    rootNode = plots
  )

  BarChart(barChartId)
  LineChart(lineChartId)
  TimeSeriesChart(timeSeriesChartId)