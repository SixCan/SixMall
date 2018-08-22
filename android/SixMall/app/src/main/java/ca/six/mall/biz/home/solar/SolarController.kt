package ca.six.mall.biz.home.solar

import android.app.Activity
import android.view.View
import ca.six.mall.util.nav
import ca.six.mall.util.navAuth

class SolarController(val activity : Activity) {

    fun clickMyOrders(v : View){
        //TODO 后续要加上登录判断
        navAuth(activity, "myOrders")
    }

    fun clickCart(v : View){
        println("szw click cart")
    }

    fun clickTrackOrder(v : View){
        println("szw click track orders")
    }

    fun clickFavorites(v : View){

    }

    fun clickCoupons(v : View){}

    fun clickVip(v : View){}
}