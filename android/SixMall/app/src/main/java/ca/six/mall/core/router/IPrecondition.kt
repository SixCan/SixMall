package ca.six.mall.core.router

import android.app.Activity

interface IPrecondition {
    fun isMatching(): Class<out Activity>?
}