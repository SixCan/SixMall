package ca.six.mall.devonly

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import ca.six.mall.R
import kotlinx.android.synthetic.main.activity_dev_only.*

class DevOnlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_only)


        solarView.addMenu(160f, R.drawable.panda, "Panda") {
            println("click panda menu")
        }
        solarView.addMenu(100f, R.drawable.panda, "Panda") {
            println("click panda menu")
        }
        solarView.draw()

/*
        val ctlay = ConstraintLayout(this)
        val btn = Button(this)
        btn.text = "Confirm"
        btn.id = View.generateViewId()
        ctlay.addView(btn)

        val constraintSet = ConstraintSet()
        constraintSet.connect(btn.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet.connect(btn.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(btn.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
        constraintSet.connect(btn.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)

        constraintSet.constrainWidth(btn.id, ConstraintSet.WRAP_CONTENT)
        constraintSet.constrainHeight(btn.id, ConstraintSet.WRAP_CONTENT)

        constraintSet.applyTo(ctlay)

        setContentView(ctlay)
*/
    }

}