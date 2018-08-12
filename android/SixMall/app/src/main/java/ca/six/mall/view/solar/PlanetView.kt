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
    var bgColor: Int = Color.TRANSPARENT
    var iconRes: Int = 0
    var text: String = ""

    init {
        orientation = VERTICAL
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        println("szw onFinishInflate()")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        println("szw onMeasure()")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        println("szw onSizeChanged()")

        val ivHeight = (h * 0.8f).toInt()
        val tvHeight = h - ivHeight

        val circleView = ImageView(context)
        circleView.setBackgroundColor(bgColor)
        circleView.setImageResource(iconRes)

        val textView = TextView(context)
        textView.setText(text)
        textView.setTextColor(Color.BLACK)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22.0f)

        //addView()自己会调用 requestLayout() 与 invalidate(true);
        println("szw --------- addView ----------- $ivHeight, $tvHeight")
        this.addView(circleView, LinearLayout.LayoutParams(ivHeight, ivHeight))
        this.addView(textView, LinearLayout.LayoutParams(w, tvHeight))

    }


    fun initData(bgColor: Int = Color.TRANSPARENT, iconRes: Int = 0, text: String = "") {
        this.bgColor = bgColor
        this.iconRes = iconRes
        this.text = text
        println("szw initData()")

        val circleView = ImageView(context)
        circleView.setBackgroundColor(bgColor)
        circleView.setImageResource(iconRes)

        val textView = TextView(context)
        textView.setText(text)
        textView.setTextColor(Color.BLACK)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22.0f)

        // addView()自己会调用 requestLayout() 与 invalidate(true);
        this.addView(circleView)
        this.addView(textView)
    }


}



