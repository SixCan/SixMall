package ca.six.mall.view.solar

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.TOP
import android.support.constraint.ConstraintSet.BOTTOM
import android.support.constraint.ConstraintSet.LEFT
import android.support.constraint.ConstraintSet.RIGHT
import android.support.constraint.ConstraintSet.PARENT_ID
import android.util.AttributeSet
import android.view.View
import ca.six.mall.util.dp2px
import ca.six.tomato.util.randomColor

/*
addMenu(icon, text, clickListener);
 */
class SolarSystemView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0)
    : ConstraintLayout(context, attr, defStyle) {

    init{
    }

    fun addMenu(sizeInDp : Float, iconResId: Int, text: String, clickListener: () -> Unit) {
        println("szw addMenu()")
        val menuView = PlanetView(context)

        menuView.id = View.generateViewId()
        menuView.setBackgroundColor(randomColor())
        menuView.initData(iconResId, text)
        menuView.setOnClickListener { clickListener() }

        val sizeInPx = context.dp2px(sizeInDp).toInt()
        this.addView(menuView, LayoutParams(sizeInPx, sizeInPx))
    }

    fun draw(){

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        println("szw onSizeChanged()")

        val cx = w / 2.0f
        val cy = h / 2.0f
        val minSize = Math.min(w, h)

        val constraintSet = ConstraintSet()
        constraintSet.clone(this)

        (0 until childCount).forEach {idx ->
            val child = getChildAt(idx)
            val lp = child.layoutParams as ConstraintLayout.LayoutParams

            if(idx == 0){
                // center
                constraintSet.connect(child.id, TOP, PARENT_ID, TOP)
                constraintSet.connect(child.id, BOTTOM, PARENT_ID, BOTTOM)
                constraintSet.connect(child.id, LEFT, PARENT_ID, LEFT)
                constraintSet.connect(child.id, RIGHT, PARENT_ID, RIGHT)
//                constraintSet.centerHorizontally(child.id, this.id)
//                constraintSet.centerVertically(child.id, this.id)
            } else {
                // planets
            }

        }
        constraintSet.applyTo(this)
    }

}