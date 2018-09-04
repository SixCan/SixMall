package ca.six.mall.biz.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.data.entity.HomeResponse

class HomeViewModel : ViewModel() {
    val keyWordHint = MutableLiveData<String>()

    fun init(){
        HttpEngine.request("home") { payload -> // worker thread
            println("szw home = $payload")
            val resp = HomeResponse(payload)

            keyWordHint.postValue(resp.hotkey)
        }
    }
}