package ca.six.mall.view.solar

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.TOP
import android.support.constraint.ConstraintSet.BOTTOM
import android.support.constraint.ConstraintSet.LEFT
import android.support.constraint.ConstraintSet.RIGHT
import android.util.AttributeSet
import android.view.View
import ca.six.mall.R
import ca.six.mall.util.dp2px

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

        println("szw this.id = ${this.id}")
        (0 until childCount).forEach {idx ->
            val child = getChildAt(idx)
            println("szw id = ${child.id}")
        }

        val constraints = ConstraintSet()
        constraints.clone(this)

        (0 until childCount).forEach {idx ->
            val child = getChildAt(idx)
            val lp = child.layoutParams as ConstraintLayout.LayoutParams

            if(idx == 0){
                // center
                constraints.connect(child.id, TOP, this.id, TOP)
                constraints.connect(child.id, BOTTOM, this.id, BOTTOM)
                constraints.connect(child.id, LEFT, this.id, LEFT)
                constraints.connect(child.id, RIGHT, this.id, RIGHT)
            } else {
                // planets
            }

            constraints.applyTo(this)
        }
    }

}