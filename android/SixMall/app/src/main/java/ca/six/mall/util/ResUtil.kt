package ca.six.mall.util

import android.content.Context
import android.util.TypedValue

fun Context.dp2px(dp : Float) : Float{
    val metrics = this.resources.displayMetrics
    val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics)
    return px
}