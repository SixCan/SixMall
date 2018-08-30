package ca.six.mall.devonly.epoxy

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.TypedEpoxyController

class EpoxyDemoController01 : TypedEpoxyController<List<CharSequence>>() {
    @AutoModel
    lateinit var header: HeaderViewModel_

    override fun buildModels(data: List<CharSequence>) {
        header.addTo(this)

        for (str in data) {
            ContentViewModel_()
                    .content(str)
                    .addTo(this)
        }

    }


}