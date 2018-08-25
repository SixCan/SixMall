package ca.six.mall.core.auth

import ca.six.mall.data.event.LoginEvent
import org.greenrobot.eventbus.EventBus

object UserManager {
    var isLogin = false
    var isVip = false
    var sessionId = ""

    fun logout(){
        this.isLogin = false
    }

    fun onLoggedin(sessionId : String){
        this.isLogin = true
        this.sessionId = sessionId
        EventBus.getDefault().post(LoginEvent())
    }


}