package ca.six.mall.biz.splash

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.ObservableField
import ca.six.mall.core.http.HttpEngine

class SplashViewModel : ViewModel() {
    val desp = MutableLiveData<String>()

    fun init(){
        HttpEngine.request("splash") { payload ->
            val imgUrl = payload.get("imgUrl") as String
//            Picasso.get().load(imgUrl).into(ivSplash)
            desp.postValue(imgUrl)
        }
    }

}