package ca.six.mall.devonly.epoxy.viewholder

import com.airbnb.epoxy.Typed2EpoxyController

class EpoxyVhController : Typed2EpoxyController<Int, List<String>>() {

    override fun buildModels(imgRes: Int, data: List<String>) {
        Header2Model_()
                .id(102)
                .imgResId(imgRes)
                .clickListener { model, parentView, clickedView, position ->
                    println("callback.onClickHeader()")
                    println("We may have a callback, which implemented by Activity")
                }
                .addTo(this)

        for (str in data) {
            Content2Model_()
                    .id(str.hashCode())
                    .text(str)
                    .addTo(this)
        }

    }


}