package ca.six.mall.biz.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.WorkerThread
import ca.six.mall.core.http.HttpEngine

class SplashViewModel : ViewModel() {
    val url = MutableLiveData<String>()

    fun init() {
        HttpEngine.request("splash") { payload, errorCode -> // worker thread
            if(errorCode != HttpEngine.CODE_SUCCESS){
                
            } else {
                val imgUrl = payload.get("imgUrl") as String
                url.postValue(imgUrl)
            }
        }
    }

}