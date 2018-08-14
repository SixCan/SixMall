package ca.six.tomato.util

import android.graphics.*
import android.support.annotation.ColorInt
import android.widget.Toast
import ca.six.mall.core.BaseApp
import java.util.*

fun showToast(text: String) {
    Toast.makeText(BaseApp.appContext, text, Toast.LENGTH_SHORT).show()
}

fun getCircleBitmap(src: Bitmap, radius: Float): Bitmap {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    val centerX = src.width / 2.0f
    val centerY = src.height / 2.0f
    println("szw util cx = $centerX, cy = $centerY, radius = $radius")

    val tempBitmap = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
    val tempCanvas = Canvas(tempBitmap)
    tempCanvas.drawCircle(centerX, centerY, radius, paint)

    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    tempCanvas.drawBitmap(src, 0f, 0f, paint)

    return tempBitmap

}

@ColorInt
fun randomColor() : Int {
    val rand = Random()
    return Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) )

}



