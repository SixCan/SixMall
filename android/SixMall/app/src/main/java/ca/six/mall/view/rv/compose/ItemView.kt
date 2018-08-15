package ca.six.mall.view.rv.compose

import ca.six.mall.view.rv.RvViewHolder

interface ItemView {
    val viewType: Int

    fun bind(holder: RvViewHolder)
}
