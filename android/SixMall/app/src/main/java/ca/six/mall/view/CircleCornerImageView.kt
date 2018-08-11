package ca.six.mall.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView

class CircleCornerImageView  @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyle: Int = 0)
    : ImageView(context, attr, defStyle) {
    val clipPath = Path()
    val drawFilter = PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
    lateinit var roundRect : RectF
    var roundRx : Float = 90.0f
    var roundRy : Float = 90.0f
    var thisWidth: Int = 0
    var thisHeight: Int = 0

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        thisWidth = w
        thisHeight = h
        roundRect = RectF(0f, 0f, w.toFloat(), h.toFloat())
    }

    override fun onDraw(canvas: Canvas) {
        canvas.setDrawFilter(drawFilter)  //抗锯齿

        clipPath.addRoundRect(roundRect, roundRx, roundRy, Path.Direction.CW)
        canvas.clipPath(clipPath)

        super.onDraw(canvas)
    }


    // not just a circle corner, the image itself is a CircleImageView
    fun setStyleAsCircle(){
        roundRx = 1.0f * thisWidth / 2
        roundRy = 1.0f * thisHeight / 2
        invalidate()
    }
}