package ca.six.mall.devonly.epoxy.binding

import ca.six.mall.DevOnlyContentBindingBindingModel_
import ca.six.mall.DevOnlyHeaderBindingBindingModel_
import ca.six.mall.devOnlyHeaderBinding
import com.airbnb.epoxy.Typed2EpoxyController

class EpoxyBindingController : Typed2EpoxyController<Int, List<String>>(){


    override fun buildModels(data1: Int, data2: List<String>) {
        DevOnlyHeaderBindingBindingModel_()
                .id(103)
                .imageResId(data1)
//                .click
                .addTo(this)

        for (str in data2) {
            DevOnlyContentBindingBindingModel_()
                    .id(str.hashCode())
                    .itemString(str)
                    .addTo(this)
        }
    }

}