package ca.six.mall.util

import android.app.Activity
import com.thejoyrun.router.Router

fun nav(from : Activity, path : String){
    Router.startActivity(from, "sixmall://$path")
}

