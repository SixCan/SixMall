package ca.six.mall.devonly.epoxy

import com.airbnb.epoxy.TypedEpoxyController

class EpoxyDemoController01 : TypedEpoxyController<List<CharSequence>>() {

    override fun buildModels(data: List<CharSequence>) {
        HeaderViewModel_()
                .id("001")
                .addTo(this)

        for (str in data) {
            ContentViewModel_()
                    .id(str.hashCode())
                    .content(str)
                    .addTo(this)
        }

    }


}