package ca.six.mall.core.router

import android.app.Activity
import ca.six.mall.core.auth.UserManager

class VipPrecondition : IPrecondition{
    override fun isMatching(): Class<out Activity>? {
        if(UserManager.isVip){
            return null
        }
    }
}