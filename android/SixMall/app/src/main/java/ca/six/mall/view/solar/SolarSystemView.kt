package ca.six.mall.view.solar

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import ca.six.mall.R
import ca.six.mall.util.dp2px

/*
addMenu(icon, text, clickListener);
 */
class SolarSystemView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0)
    : ConstraintLayout(context, attr, defStyle) {

    init{
        this.id = R.id.solar_system_sun
    }

    fun addMenu(sizeInDp : Float, iconResId: Int, text: String, clickListener: () -> Unit) {
        println("szw addMenu()")
        val menuView = PlanetView(context)

        menuView.initData(iconResId, text)
        menuView.setOnClickListener { clickListener() }

        val sizeInPx = context.dp2px(sizeInDp).toInt()
        this.addView(menuView, LayoutParams(sizeInPx, sizeInPx))
    }

    fun draw(){

    }

//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        println("szw onSizeChanged()")
//
//        val cx = w / 2.0f
//        val cy = h / 2.0f
//        val minSize = Math.min(w, h)
//
//        (0 until childCount).forEach {idx ->
//            val child = getChildAt(idx)
//            val lp = child.layoutParams as ConstraintLayout.LayoutParams
//
//            if(idx == 0){
//                // center
//                lp.leftToLeft = this.id
//                lp.rightToLeft = this.id
//                lp.topToTop = this.id
//                lp.bottomToBottom = this.id
//            } else {
//                // planets
//            }
//        }
//    }

}