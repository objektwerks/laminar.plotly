package objektwerks

import plotly.{Config, Plotly, Scatter}
import plotly.layout.Layout

object TimeSeriesChart:
  def apply(id: String): Unit =
    val series = Scatter(
      Seq("2025-05-10 09:21:00", "2025-05-10 10:31:00", "2025-05-10 11:41:00", "2025-05-10 12:51:00"),
      Seq(1, 6, 3, 9)
    )

    val data = Seq(series)

    val layout = Layout().withTitle("Time Series Chart")
  
    val config = Config(responsive = true)

    Plotly.plot(
      div = id,
      data = data,
      layout = layout,
      config = config
    )

    ()