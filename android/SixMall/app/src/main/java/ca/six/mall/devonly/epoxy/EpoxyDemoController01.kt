package ca.six.mall.devonly.epoxy

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.Typed2EpoxyController

class EpoxyDemoController01 : Typed2EpoxyController<Unit, String>() {
    @AutoModel lateinit var header : HeaderViewModel_
    @AutoModel lateinit var content : ContentViewModel_

    override fun buildModels(data1: Unit, data2: String) {
        content.content(data2)
    }
}