package ca.six.mall.util

import android.content.Context
import android.util.TypedValue

fun Context.dp2px(dp : Float) : Float{
    val metrics = this.resources.displayMetrics
    val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics)
    return px
}

fun Context.px2dp(px: Float) : Float {
    val metrics = this.resources.displayMetrics
    val dp = px / metrics.density
    return dp
}