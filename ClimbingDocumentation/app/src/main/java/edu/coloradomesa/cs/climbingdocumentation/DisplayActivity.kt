package edu.coloradomesa.cs.climbingdocumentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.coloradomesa.cs.climbingdocumentation.ClimbInfo
import kotlinx.android.synthetic.main.display_climbs.*


class DisplayActivity : AppCompatActivity() {

    var i: Int = 0
    private var tempClimbList = ArrayList<ClimbInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val climbsList = intent.getSerializableExtra("climbsList") as? ArrayList<ClimbInfo>
        if (climbsList != null) {
            tempClimbList = climbsList
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_climbs)
        if (climbsList != null) {
            if (climbsList.size == 0) {
                dispClimbType.setText(R.string.no_climbs_in_list1)
                dispClimbName.setText(R.string.no_climbs_in_list2)
            }
            else {
                dispClimbType.setText(climbsList.get(0).type)
                dispClimbName.setText(climbsList.get(0).name)
                dispClimbGrade.setText(climbsList.get(0).grade)
                dispClimbDate.setText(climbsList.get(0).date)
            }
        }
        else {
            dispClimbType.setText(R.string.no_climbs_in_list1)
            dispClimbName.setText(R.string.no_climbs_in_list2)
        }
    }

    fun goToMainAct(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("climbsList",tempClimbList)
        startActivity(intent)
    }

    fun nextClimb(view: View) {
        if(i < tempClimbList.size - 1) {
            i++
            dispClimbType.setText(tempClimbList.get(i).type)
            dispClimbName.setText(tempClimbList.get(i).name)
            dispClimbGrade.setText(tempClimbList.get(i).grade)
            dispClimbDate.setText(tempClimbList.get(i).date)
        }
    }

    fun lastClimb(view: View) {
        if(i > 0) {
            i--
            dispClimbType.setText(tempClimbList.get(i).type)
            dispClimbName.setText(tempClimbList.get(i).name)
            dispClimbGrade.setText(tempClimbList.get(i).grade)
            dispClimbDate.setText(tempClimbList.get(i).date)
        }
    }
}