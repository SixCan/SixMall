package ca.six.mall.view.solar

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ca.six.mall.R
import ca.six.tomato.util.getCircleBitmap

/*
[使用建议]
    * 宽高建议至少是100dp, 至多不要过200dp
    * 且因为没有对wrap_content做处理, 所以暂时也不支持wrap_content
 */

class PlanetView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : LinearLayout(context, attrs, defStyle) {
    @DrawableRes var iconRes: Int = 0

    lateinit var circleView: ImageView
    lateinit var textView: TextView

    init {
        orientation = VERTICAL

        val ta = context.obtainStyledAttributes(attrs, R.styleable.PlanetView)
        val iconResId = ta.getResourceId(R.styleable.PlanetView_picon, R.drawable.ic_launcher)
        val text = ta.getString(R.styleable.PlanetView_ptext)
        initData(iconResId, text)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val w = MeasureSpec.getSize(widthMeasureSpec)
        val h = MeasureSpec.getSize(heightMeasureSpec)

        val ivHeight = (h * 0.75f).toInt()
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

        val textSize = h / 17.0f
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize)

        val srcBitmap = BitmapFactory.decodeResource(resources, iconRes)
        val circleBitmap = getCircleBitmap(srcBitmap, w / 2.0f)  //这不用ivHeight/2, 是因为对iv来说, this.w比iv.w更大
        circleView.setImageBitmap(circleBitmap)
    }

    fun initData(iconRes: Int = 0, text: String = "") {
        this.iconRes = iconRes

        circleView = ImageView(context)

        textView = TextView(context)
        textView.setText(text)
        textView.setTextColor(Color.BLACK)

        // addView()自己会调用 requestLayout() 与 invalidate(true);
        this.addView(circleView)
        this.addView(textView)
    }

}



