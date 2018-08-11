package ca.six.mall.view.solar

import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import ca.six.mall.view.CircleCornerImageView


class PlanetView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0)
    : LinearLayout(context, attr, defStyle) {

    init {
        orientation = VERTICAL
    }

    fun initData(bgColor : Int = Color.TRANSPARENT, iconRes : Int = 0, text : String = ""){
        val circleView = CircleCornerImageView(context)
        circleView.setStyleAsCircle()
        circleView.setBackgroundColor(bgColor)
        circleView.setImageResource(iconRes)

        val textView = TextView(context)
        textView.setText(text)

        this.addView(circleView)
        this.addView(textView)
        invalidate()
    }





}



