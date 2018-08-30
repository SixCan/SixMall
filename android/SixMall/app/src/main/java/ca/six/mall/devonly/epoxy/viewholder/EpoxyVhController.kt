package ca.six.mall.devonly.epoxy.viewholder

import com.airbnb.epoxy.Typed2EpoxyController

class EpoxyVhController : Typed2EpoxyController<Int, List<CharSequence>>() {

    override fun buildModels(data1: Int?, data2: List<CharSequence>?) {

    }

//    override fun buildModels(data: List<CharSequence>) {
//        HeaderViewModel_()
//                .id("001")
//                .addTo(this)
//
//        for (str in data) {
//            ContentViewModel_()
//                    .id(str.hashCode())
//                    .content(str)
//                    .addTo(this)
//        }
//
//    }

}