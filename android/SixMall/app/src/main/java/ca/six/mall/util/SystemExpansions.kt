package ca.six.mall.util

import android.app.Activity
import ca.six.mall.core.auth.UserManager
import com.thejoyrun.router.Router

fun nav(from : Activity, path : String){
    Router.startActivity(from, "sixmall://$path")
}

fun navAuth(from: Activity, path : String){
    if(UserManager.isLogin){
        nav(from, path)
    } else {
        nav(from, "login/$path")
    }
}

