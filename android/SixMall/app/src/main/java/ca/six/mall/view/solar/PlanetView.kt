package ca.six.mall.view.solar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ca.six.mall.view.CircleCornerImageView


class PlanetView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0)
    : LinearLayout(context, attr, defStyle) {
    var ivHeight  = 0
    var tvHeight  = 0
    var thisWidth  = 0

    init {
        orientation = VERTICAL
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        thisWidth = MeasureSpec.getSize(widthMeasureSpec)
        val thisHeight = MeasureSpec.getSize(heightMeasureSpec)

        ivHeight = (thisHeight * 0.8f).toInt()
        tvHeight = thisHeight - ivHeight

        println("szw thisWidth = $thisWidth ; thisHeight = $thisHeight")
        println("szw ivHeight = $ivHeight ; tvHeight = $tvHeight")

    }


    fun initData(bgColor: Int = Color.TRANSPARENT, iconRes: Int = 0, text: String = "") {
        val circleView = ImageView(context)
//        circleView.setStyleAsCircle()
        circleView.setBackgroundColor(bgColor)
        circleView.setImageResource(iconRes)

        val textView = TextView(context)
        textView.setText(text)
        textView.setTextColor(Color.BLACK)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22.0f)

        //addView()自己会调用 requestLayout() 与 invalidate(true);
        println("szw --------- addView ----------- $ivHeight, $tvHeight")
        this.addView(circleView, LinearLayout.LayoutParams(ivHeight, ivHeight))
        this.addView(textView, LinearLayout.LayoutParams(thisWidth, tvHeight))
    }


}



