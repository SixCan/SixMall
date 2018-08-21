package ca.six.mall.core.router.precondition

import ca.six.mall.biz.login.LoginActivity
import ca.six.mall.core.auth.UserManager

class LoginPrecondition : IPrecondition {
    override fun isMatching(): FilterResult {
        if(UserManager.isLogin){
            return EmptyFilterResult()
        } else {
            return FilterResult(LoginActivity::class.java)
        }
    }
}