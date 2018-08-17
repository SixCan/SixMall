package ca.six.mall.devonly.oneadapter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.six.mall.devonly.pojo.DevOnlyUser

class DevOnlyRvViewModel : ViewModel() {
    var data = MutableLiveData<List<DevOnlyUser>>()

    fun init() {
        Thread(object : Runnable {
            override fun run() {
                println("szw before sleep")
                Thread.sleep(2000)
                println("szw after sleep")

                val list = ArrayList<DevOnlyUser>()
                (1..15).forEach { list.add(DevOnlyUser("item$it", it)) }
                data.postValue(list)
            }
        }).start()
    }
}