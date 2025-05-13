package objektwerks

import plotly.{Bar, Config, Plotly}
import plotly.layout.Layout

object BarChart:
  def apply(id: String): Unit =
    val series = Bar(
      Seq("porsche", "ferrari", "maserati"),
      Seq(10, 8, 6)
    )
    
    val data = Seq(series)

    val layout = Layout().withTitle("Bar Chart")
  
    val config = Config(responsive = true)

    Plotly.plot(
      div = id,
      data = data,
      layout = layout,
      config = config
    )

    ()