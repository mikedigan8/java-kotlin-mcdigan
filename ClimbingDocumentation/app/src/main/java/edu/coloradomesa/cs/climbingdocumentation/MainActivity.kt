package edu.coloradomesa.cs.climbingdocumentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import androidx.core.view.isEmpty
import edu.coloradomesa.cs.climbingdocumentation.ClimbInfo

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var climbsList = ArrayList<ClimbInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToDisplayList(view: View) {
        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("climbList", climbsList)
        startActivity(intent)
    }

    fun addClimbToList(view: View) {
        if (mainClimbName.text.isEmpty()) mainClimbName.setText(R.string.no_name)
        else if (mainClimbGrade.text.isEmpty()) mainClimbGrade.setText(R.string.no_grade)
        else if (mainClimbDate.text.isEmpty()) mainClimbDate.setText(R.string.no_date)
        else {
            val type: Char
            if(boulderClimb.isChecked) type = 'B'
            else type = 'R'
            val newClimb = ClimbInfo(type, mainClimbName.toString(), mainClimbGrade.toString(), mainClimbDate.toString())
            climbsList.add(newClimb)
        }
    }
}