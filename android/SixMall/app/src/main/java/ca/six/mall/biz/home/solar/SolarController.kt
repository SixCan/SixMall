package ca.six.mall.biz.home.solar

import android.app.Activity
import android.view.View
import ca.six.mall.core.auth.UserManager
import ca.six.mall.util.nav
import ca.six.mall.util.navAuth

class SolarController {
    var isLogin = false

    fun clickMyAccount(v : View){

    }

    fun clickLogout(v : View){
        UserManager.logout()
    }

    fun clickMyOrders(v : View){
        navAuth("myOrders")
    }

    fun clickCart(v : View){
    }

    fun clickTrackOrder(v : View){
        // TODO 以后换成"trace my last order"
        navAuth("myOrders")
    }

    fun clickFavorites(v : View){

    }

    fun clickCoupons(v : View){}

    fun clickVip(v : View){}
}