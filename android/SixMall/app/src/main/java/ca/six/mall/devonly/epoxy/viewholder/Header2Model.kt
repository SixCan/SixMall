package ca.six.mall.devonly.epoxy.viewholder

import android.support.annotation.DrawableRes
import android.view.View
import ca.six.mall.R
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash


//abstract是因为没有实现getDefaultLayout()等方法, which is provided by the annotation
@EpoxyModelClass(layout = R.layout.item_dev_only_header_vh)
abstract class Header2Model : EpoxyModelWithHolder<EpoxyViewHolder>() {

    @EpoxyAttribute @DrawableRes val imgResId : Int = 0

    @EpoxyAttribute(DoNotHash) lateinit var clickListener: View.OnClickListener

    override fun bind(holder: EpoxyViewHolder) {
        super.bind(holder)
        holder.setSrc(R.id.ivItemHeader, imgResId)
        holder.setClickListener(R.id.ivItemHeader, clickListener)
    }

}