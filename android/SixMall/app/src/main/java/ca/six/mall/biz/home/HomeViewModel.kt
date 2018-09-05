package ca.six.mall.biz.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.biz.home.solar.SolarController
import ca.six.mall.core.auth.UserManager
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.data.entity.HomeResponse
import ca.six.mall.data.event.SingleLiveEvent
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow
import ca.six.mall.view.rv.one_binding_types.ID_Model

class HomeViewModel : ViewModel() {
    val keyWordHint = MutableLiveData<String>()
    var homeRows : ArrayList<BindingTypesRow> = ArrayList()


    fun init(){
        HttpEngine.request("home") { payload -> // worker thread
            println("szw home = $payload")
            val resp = HomeResponse(payload)

            keyWordHint.postValue(resp.hotkey)

        }

        initHomeRows()
    }

    private fun initHomeRows(){
        homeRows.clear()
        val solarController = SolarController()
        val solarControllerBinder = ID_Model(BR.controller, solarController)
        val solarLoginBinder = ID_Model(BR.auth, UserManager)
        homeRows.add(BindingTypesRow(R.layout.item_solar_menus, solarControllerBinder, solarLoginBinder))

    }

}