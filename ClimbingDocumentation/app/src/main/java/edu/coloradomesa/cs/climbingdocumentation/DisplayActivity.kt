package edu.coloradomesa.cs.climbingdocumentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import androidx.core.view.isEmpty
import edu.coloradomesa.cs.climbingdocumentation.ClimbInfo
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.display_climbs.*

class DisplayActivity : AppCompatActivity() {

    var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        val climbsList = intent.getSerializableExtra("climbsList") as? ArrayList<ClimbInfo>
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_climbs)
        if (climbsList != null) {
            if (i > climbsList.size - 1) i = climbsList.size - 1
            else if (i < 0) i = 0
            else if (climbsList.get(i).type == " ") {
                dispClimbType.setText(R.string.no_climbs_in_list1)
                dispClimbName.setText(R.string.no_climbs_in_list2)
            }
            else {
                dispClimbType.setText(climbsList.get(i).type)
                dispClimbName.setText(climbsList.get(i).name)
                dispClimbGrade.setText(climbsList.get(i).grade)
                dispClimbDate.setText(climbsList.get(i).date)
            }
        }
    }

    fun goToMainAct(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun nextClimb(view: View) {
        i++;
    }

    fun lastClimb(view: View) {
        i--;
    }
}