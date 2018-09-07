package ca.six.mall.util

import android.content.Context
import android.graphics.*
import android.support.annotation.ColorInt
import android.widget.Toast
import ca.six.mall.core.BaseApp
import java.util.*

fun showToast(text: String) {
    Toast.makeText(BaseApp.appContext, text, Toast.LENGTH_SHORT).show()
}

fun getVectorBitmap(ctx: Context, iconRes: Int, width: Int = 0, height: Int = 0): Bitmap {
    // vector pictures
    val drawable = ctx.getDrawable(iconRes) //=> 若是vector, 则drawable的类型是android.graphics.drawable.VectorDrawable

    var w = width
    var h = height
    if (w == 0) {
        w = drawable.intrinsicWidth
    }
    if (h == 0) {
        h = drawable.intrinsicHeight
    }

    val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}


fun getCircleBitmap(src: Bitmap, radius: Float): Bitmap {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    val centerX = src.width / 2.0f
    val centerY = src.height / 2.0f
//    println("szw util cx = $centerX, cy = $centerY, radius = $radius")

    val tempBitmap = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
    val tempCanvas = Canvas(tempBitmap)
    tempCanvas.drawCircle(centerX, centerY, radius, paint)

    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    tempCanvas.drawBitmap(src, 0f, 0f, paint)

    return tempBitmap

}

@ColorInt
fun randomColor(): Int {
    val rand = Random()
    return Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))

}



