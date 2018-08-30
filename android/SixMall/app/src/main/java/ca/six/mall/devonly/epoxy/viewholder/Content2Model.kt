package ca.six.mall.devonly.epoxy.viewholder

import ca.six.mall.R
import ca.six.mall.view.epoxy.EpoxyViewHolder
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.item_dev_only_content_vh)
abstract class Content2Model : EpoxyModelWithHolder<EpoxyViewHolder>() {

    @EpoxyAttribute var text: String = ""

    override fun bind(holder: EpoxyViewHolder) {
        super.bind(holder)
        holder.setText(R.id.tvItemContent, text)
    }
}