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

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        roundRect = RectF(0f, 0f, w.toFloat(), h.toFloat())
    }

    override fun onDraw(canvas: Canvas) {
        canvas.setDrawFilter(drawFilter)  //抗锯齿

        clipPath.addRoundRect(roundRect, 90.0f, 90.0f, Path.Direction.CW)
        canvas.clipPath(clipPath)

        super.onDraw(canvas)
    }
}