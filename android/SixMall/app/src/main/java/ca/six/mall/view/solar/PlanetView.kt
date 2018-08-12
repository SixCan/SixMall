package ca.six.mall.view.solar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ca.six.mall.view.CircleCornerImageView


class PlanetView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0)
    : LinearLayout(context, attr, defStyle) {
    var bgColor: Int = Color.TRANSPARENT
    var iconRes: Int = 0
    var text: String = ""

    lateinit var circleView : ImageView
    lateinit var textView : TextView

    init {
        orientation = VERTICAL
        setBackgroundColor(Color.GRAY)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        println("szw onMeasure()")

        val w = MeasureSpec.getSize(widthMeasureSpec)
        val h = MeasureSpec.getSize(heightMeasureSpec)

        val ivHeight = (h * 0.8f).toInt()
        val tvHeight = h - ivHeight

        circleView.measure(MeasureSpec.makeMeasureSpec(ivHeight, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(ivHeight, MeasureSpec.EXACTLY))
        textView.measure(MeasureSpec.makeMeasureSpec(w, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(tvHeight, MeasureSpec.EXACTLY))
    }


    fun initData(bgColor: Int = Color.TRANSPARENT, iconRes: Int = 0, text: String = "") {
        this.bgColor = bgColor
        this.iconRes = iconRes
        this.text = text
        println("szw initData()")

        circleView = ImageView(context)
        circleView.setBackgroundColor(bgColor)
        circleView.setImageResource(iconRes)

        textView = TextView(context)
        textView.setText(text)
        textView.setTextColor(Color.BLACK)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22.0f)

        // addView()自己会调用 requestLayout() 与 invalidate(true);
        this.addView(circleView)
        this.addView(textView)
    }

}



