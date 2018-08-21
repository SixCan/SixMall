package ca.six.mall.util

import android.app.Activity
import android.content.Intent
import ca.six.mall.core.router.IPrecondition

fun Activity.nav(clz: Class<out Any>) {
    val it = Intent(this, clz)
    this.startActivity(it)
}

fun Activity.nav(clz: Class<out Any>, args: Map<String, String>) {
    val it = Intent(this, clz)
    for ((k, v) in args) {
        it.putExtra(k, v)
    }
    this.startActivity(it)
}

fun Activity.nav(clz: Class<out Activity>, vararg preconditions: IPrecondition) {

}

