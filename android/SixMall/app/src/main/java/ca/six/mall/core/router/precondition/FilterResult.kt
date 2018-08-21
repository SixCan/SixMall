package ca.six.mall.core.router.precondition

import android.app.Activity

open class FilterResult(val clazz: Class<out Activity>?,
                        val args: Map<String, String>? = null,
                        var errorMessage: String = "")

class EmptyFilterResult : FilterResult(null, null){
}