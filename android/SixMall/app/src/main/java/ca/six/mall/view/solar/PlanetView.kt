package ca.six.mall.view.solar

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ca.six.mall.R
import ca.six.mall.util.px2dp
import ca.six.tomato.util.getCircleBitmap
import ca.six.tomato.util.getVectorBitmap
import ca.six.tomato.util.randomColor

/*
[使用建议]
    * height : width = 100 : 75的样子, 效果最佳
    * 且因为没有对wrap_content做处理, 所以暂时也不支持wrap_content
 */

class PlanetView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : LinearLayout(context, attrs, defStyle) {
    @DrawableRes var iconRes: Int = 0
    var ivHeight = 0

    lateinit var circleView: ImageView
    lateinit var textView: TextView

    init {
        orientation = VERTICAL

        val ta = context.obtainStyledAttributes(attrs, R.styleable.PlanetView)
        val iconResId = ta.getResourceId(R.styleable.PlanetView_planet_icon, R.drawable.ic_launcher)
        val text = ta.getString(R.styleable.PlanetView_planet_text)
        val color = ta.getColor(R.styleable.PlanetView_planet_iconColor, Color.BLACK)
        val textSize = ta.getDimension(R.styleable.PlanetView_planet_textSize, 30f)
        val textSizeInDp = context.px2dp(textSize)
        initData(iconResId, color, text, textSizeInDp)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val w = MeasureSpec.getSize(widthMeasureSpec)
        val h = MeasureSpec.getSize(heightMeasureSpec)

        ivHeight = (h * 0.7f).toInt()
        val tvHeight = h - ivHeight

        circleView.measure(MeasureSpec.makeMeasureSpec(ivHeight, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(ivHeight, MeasureSpec.EXACTLY))
        textView.measure(MeasureSpec.makeMeasureSpec(w, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(tvHeight, MeasureSpec.EXACTLY))

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // 下面几行代码放onMeasure()也行, 但会被调用多次, 不如放这里. 后面onLayout()调用时再放置
        val ivLp = circleView.layoutParams as LinearLayout.LayoutParams
        ivLp.gravity = Gravity.CENTER_HORIZONTAL  // android:layout_gravity

        textView.gravity = Gravity.CENTER  // android:gravity

        circleView.setImageResource(iconRes)

        //TODO delete
//        println("szw view.onSizeChanged() -- w = $w, h = $h, ivS = $ivHeight")
//        circleView.setBackgroundColor(randomColor())
//        textView.setBackgroundColor(randomColor())
    }

    fun initData(iconRes: Int = 0, @ColorInt iconColor : Int, text: String = "", textSizeInDp : Float) {
        this.iconRes = iconRes

        circleView = ImageView(context)
        circleView.setColorFilter(iconColor)

        textView = TextView(context)
        textView.setText(text)
        textView.setTextColor(Color.BLACK)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSizeInDp)

        // addView()自己会调用 requestLayout() 与 invalidate(true);
        this.addView(circleView)
        this.addView(textView)
    }

}



