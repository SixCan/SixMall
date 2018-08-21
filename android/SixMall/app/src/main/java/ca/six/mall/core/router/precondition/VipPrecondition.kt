package ca.six.mall.core.router.precondition

import ca.six.mall.biz.error.ErrorActivity
import ca.six.mall.core.auth.UserManager

class VipPrecondition : IPrecondition {
    override fun isMatching(): FilterResult {
        if(UserManager.isVip){
            return EmptyFilterResult()
        } else {
            // TODO 后续跳"充vip"页面
            return FilterResult(ErrorActivity::class.java, null, "Not a VIP")
        }
    }
}