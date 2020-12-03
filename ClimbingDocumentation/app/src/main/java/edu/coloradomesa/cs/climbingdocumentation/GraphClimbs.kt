package edu.coloradomesa.cs.climbingdocumentation

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import java.util.*

class GraphClimbs : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph_climbs)
        drawChart()
    }

    private fun drawChart() {
        val barChart: BarChart = findViewById(R.id.barChart)
        barChart.setDrawBarShadow(false)
        barChart.setDrawValueAboveBar(true)
        val description = Description()
        description.text = ""
        barChart.description = description
        barChart.setMaxVisibleValueCount(50)
        barChart.setPinchZoom(false)
        barChart.setDrawGridBackground(false)
        val xl = barChart.xAxis
        xl.granularity = 1f
        xl.setCenterAxisLabels(true)
        val leftAxis = barChart.axisLeft
        leftAxis.setDrawGridLines(false)
        leftAxis.spaceTop = 30f
        barChart.axisRight.isEnabled = false

        //data
        val groupSpace = 0.04f
        val barSpace = 0.02f
        val barWidth = 0.46f
        val startYear = 1980
        val endYear = 1985
        val yVals1: MutableList<BarEntry> = ArrayList()
        val yVals2: MutableList<BarEntry> = ArrayList()
        for (i in startYear until endYear) {
            yVals1.add(BarEntry(i as Float, 0.4f))
        }
        for (i in startYear until endYear) {
            yVals2.add(BarEntry(i as Float, 0.7f))
        }
        val set1: BarDataSet
        val set2: BarDataSet
        if (barChart.data != null && barChart.data.dataSetCount > 0) {
            set1 = barChart.data.getDataSetByIndex(0) as BarDataSet
            set2 = barChart.data.getDataSetByIndex(1) as BarDataSet
            set1.values = yVals1
            set2.values = yVals2
            barChart.data.notifyDataChanged()
            barChart.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(yVals1, "Company A")
            set1.color = Color.rgb(104, 241, 175)
            set2 = BarDataSet(yVals2, "Company B")
            set2.color = Color.rgb(164, 228, 251)
            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(set1)
            dataSets.add(set2)
            val data = BarData(dataSets)
            barChart.data = data
        }
        barChart.barData.barWidth = barWidth
        barChart.groupBars(startYear.toFloat(), groupSpace, barSpace)
        barChart.invalidate()
    }
}