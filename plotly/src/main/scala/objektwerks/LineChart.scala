package objektwerks

import plotly.{Config, Plotly, Scatter}
import plotly.layout.Layout

object LineChart:
  def apply(id: String): Unit =
    val series1 = Scatter(
      x = Seq(1, 2, 3, 4),
      y = Seq(3, 7, 5, 9)
    ).withName("series 1")

    val series2 = Scatter(
      x = Seq(1, 2, 3, 4),
      y = Seq(10, 4, 8, 6)
    ).withName("series 2")
    
    val data = Seq(series1, series2)
  
    val layout = Layout().withTitle("Line Chart")
  
    val config = Config(responsive = true)
      
    Plotly.plot(
      path = id,
      traces = data,
      layout = layout,
      config = config
    )