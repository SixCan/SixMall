package ca.six.mall.biz.splash

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.ObservableField
import ca.six.mall.core.http.HttpEngine

class SplashViewModel : ViewModel() {
    var desp = ObservableField<String>()

    fun init(){
//        HttpEngine.request("splash") { payload ->
//            val imgUrl = payload.get("imgUrl") as String
////            Picasso.get().load(imgUrl).into(ivSplash)
//            println("szw img = $imgUrl ; thread = ${Thread.currentThread().name}")
//            desp.set(imgUrl)
//        }
        desp.set("!!! , databinding")
    }

}