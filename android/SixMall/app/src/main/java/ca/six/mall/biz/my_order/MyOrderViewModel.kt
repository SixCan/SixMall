package ca.six.mall.biz.my_order

import android.arch.lifecycle.MutableLiveData
import ca.six.mall.data.entity.Order

class MyOrderViewModel {
    var orders = MutableLiveData<List<Order>>()
    var isEmpty = MutableLiveData<Boolean>() //转成java会生成了isEmpty(), setEmpty()方法. -- layout xml中可用

    init{
        clearList()
    }

    private fun clearList(){
        orders.value = null
        isEmpty.value = false
    }

}