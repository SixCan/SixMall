package ca.six.mall.biz.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.biz.home.solar.SolarController
import ca.six.mall.core.auth.UserManager
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.data.entity.HomeResponse
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow
import ca.six.mall.view.rv.one_binding_types.ID_Model

class HomeViewModel : ViewModel() {
    val keyWordHint = MutableLiveData<String>()
    var homeRows: ArrayList<BindingTypesRow> = ArrayList()


    fun init() {
        println("szw vm init() 01")
        HttpEngine.request("home") { payload ->
            // worker thread
            println("szw home = $payload")
            val resp = HomeResponse(payload)

            keyWordHint.postValue(resp.hotkey)

            println("szw vm init() callback 02")
            initHomeRows()

            println("szw vm init() callback 03")
            if (resp.recommendations.size > 0) {
                val id_model = ID_Model(BR.title, "Recommendations")
                homeRows.add(BindingTypesRow(R.layout.item_title_text_medium, id_model))
            }
            resp.recommendations.forEach { item ->
                val id_model = ID_Model(BR.model, item)
                homeRows.add(BindingTypesRow(R.layout.item_home_recommend, id_model))
            }
            println("szw vm init() callback 03")

        }

        initHomeRows()
        println("szw vm init() 04")
    }

    private fun initHomeRows() {
        homeRows.clear()
        val solarController = SolarController()
        val solarControllerBinder = ID_Model(BR.controller, solarController)
        val solarLoginBinder = ID_Model(BR.auth, UserManager)
        homeRows.add(BindingTypesRow(R.layout.item_solar_menus, solarControllerBinder, solarLoginBinder))

    }

}