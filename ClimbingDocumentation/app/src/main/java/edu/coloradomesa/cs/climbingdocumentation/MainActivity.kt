package edu.coloradomesa.cs.climbingdocumentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val climbsList = ArrayList<ClimbInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToDisplayList(view: View) {
        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("climbsList",climbsList)
        startActivity(intent)
    }

    fun addClimbToList(view: View) {
        var add: Boolean = true
        if (mainClimbName.text.isEmpty()) {
            mainClimbName.setText(R.string.no_name)
            add = false
        }
        if (mainClimbGrade.text.isEmpty()) {
            mainClimbGrade.setText(R.string.no_grade)
            add = false
        }
        if (mainClimbDate.text.isEmpty()) {
            mainClimbDate.setText(R.string.no_date)
            add = false
        }
        if(add) {
            val type: String
            if(boulderClimb.isChecked) type = "Boulder"
            else type = "Roped Climb"
            val newClimb = ClimbInfo(type, mainClimbName.toString(), mainClimbGrade.toString(), mainClimbDate.toString())
            climbsList.add(newClimb)
            mainClimbName.setText("")
            mainClimbGrade.setText("")
            mainClimbDate.setText("")
        }
    }
}
