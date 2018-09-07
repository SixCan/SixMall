package ca.six.mall.core.auth

import ca.six.mall.data.event.LoginEvent
import ca.six.mall.data.event.LogoutEvent
import ca.six.mall.util.showToast
import org.greenrobot.eventbus.EventBus

object UserManager {
    var isLogin = false
    var isVip = false
    var session = ""

    fun logout(){
        this.isLogin = false
        this.session = ""
        showToast("You have logged out!")
        EventBus.getDefault().post(LogoutEvent())
    }

    fun onLoggedin(sessionId : String){
        this.isLogin = true
        this.session = sessionId
        EventBus.getDefault().post(LoginEvent())
    }


}