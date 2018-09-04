package ca.six.mall.util

import android.app.Activity
import ca.six.mall.core.BaseApp
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


/*
Why application context works here?
: because the Router class makes an exception:
```
    if (!(context instanceof Activity)) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
```
 */
fun nav(path : String){
    Router.startActivity(BaseApp.appContext, "sixmall://$path")
}

// TODO refactor this. Should have no duplication
fun navAuth( path : String){
    if(UserManager.isLogin){
        nav(path)
    } else {
        nav("login/$path")
    }
}

