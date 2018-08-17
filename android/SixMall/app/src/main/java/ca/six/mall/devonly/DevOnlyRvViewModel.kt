package ca.six.mall.devonly

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class DevOnlyRvViewModel : ViewModel() {
    var data = MutableLiveData<List<String>>()

    fun init(){
        Thread(object : Runnable{
            override fun run() {
                println("szw before sleep")
                Thread.sleep(2000)
                println("szw after sleep")

                val list = ArrayList<String>()
                (1..5).forEach { list.add("item $it") }
                data.postValue(list)
            }
        }).start()
    }
}