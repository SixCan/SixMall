package ca.six.mall.biz.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.biz.home.solar.SolarController
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.data.entity.HomeResponse
import ca.six.mall.data.event.SingleLiveEvent
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow

class HomeViewModel : ViewModel() {
    val keyWordHint = MutableLiveData<String>()
    private lateinit var list: ArrayList<BindingTypesRow<*>>
    var getServerDataEvent = SingleLiveEvent<HomeResponse>()


    fun init(){
        HttpEngine.request("home") { payload -> // worker thread
            println("szw home = $payload")
            val resp = HomeResponse(payload)

            keyWordHint.postValue(resp.hotkey)

            getServerDataEvent.postValue(resp)
        }
    }

    fun rows(): List<BindingTypesRow<*>> {
        list = ArrayList()

        // solar menus
        val solarController = SolarController()
        list.add(BindingTypesRow(R.layout.item_solar_menus, BR.controller, solarController))

        return list
    }
}