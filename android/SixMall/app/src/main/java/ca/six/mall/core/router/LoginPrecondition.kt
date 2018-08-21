package ca.six.mall.core.router

import android.app.Activity
import ca.six.mall.biz.login.LoginActivity
import ca.six.mall.core.auth.UserManager

class LoginPrecondition : IPrecondition {
    override fun isMatching(): Class<out Activity>? {
        if(UserManager.isLogin){
            return null
        } else {
            return LoginActivity::class.java
        }
    }
}