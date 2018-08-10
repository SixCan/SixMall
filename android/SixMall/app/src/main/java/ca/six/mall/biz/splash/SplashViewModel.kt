package ca.six.mall.biz.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.six.mall.core.http.HttpEngine

class SplashViewModel : ViewModel() {
    val desp = MutableLiveData<String>()
    val url = MutableLiveData<String>()

    fun init() {
        HttpEngine.request("splash") { payload -> // main thread
            val imgUrl = payload.get("imgUrl") as String
            desp.postValue(imgUrl)
            url.postValue(imgUrl)
        }
    }

}