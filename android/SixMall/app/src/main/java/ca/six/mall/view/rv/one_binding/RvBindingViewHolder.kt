package ca.six.mall.view.rv.one_binding

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import ca.six.mall.BR


class RvBindingViewHolder(private val binding: ViewDataBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }
}
