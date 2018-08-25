package ca.six.mall.biz.home.solar

import android.app.Activity
import android.view.View
import ca.six.mall.core.auth.UserManager
import ca.six.mall.util.nav
import ca.six.mall.util.navAuth

class SolarController(val activity : Activity) {
    var isLogin = false

    fun clickMyAccount(v : View){

    }

    fun clickLogout(v : View){
        UserManager.logout()
    }

    fun clickMyOrders(v : View){
        navAuth(activity, "myOrders")
    }

    fun clickCart(v : View){
        println("szw click cart")
        //TODO delete later (放这是方便测试)
        UserManager.logout()
    }

    fun clickTrackOrder(v : View){
        // TODO 以后换成"trace my last order"
        navAuth(activity, "myOrders")
    }

    fun clickFavorites(v : View){

    }

    fun clickCoupons(v : View){}

    fun clickVip(v : View){}
}