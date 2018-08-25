package ca.six.mall.core.auth

object UserManager {
    var isLogin = false
    var isVip = false
    var sessionId = ""

    fun logout(){
        isLogin = false
    }

    fun onLoggedin(){
        isLogin = true
        //TODO may have observer to observe on the login action
    }


}