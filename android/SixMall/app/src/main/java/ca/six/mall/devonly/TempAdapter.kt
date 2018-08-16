package ca.six.mall.devonly

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import ca.six.mall.view.rv.RvViewHolder
import ca.six.mall.view.rv.one_binding.RvBindingViewHolder

class TempAdapter<T>(var layoutResId: Int, var bindingVariable: Int, var data: List<T>? = null)
    : Adapter<RvBindingViewHolder>() {
    var inflater : LayoutInflater? = null

    override fun getItemCount(): Int {
        return if(data == null) 0 else data!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvBindingViewHolder {
        inflater = inflater ?: LayoutInflater.from(parent.context)
        val binding : ViewDataBinding = DataBindingUtil.inflate(inflater!!, layoutResId, parent, false)
        return RvBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvBindingViewHolder, position: Int) {
        val item = data!!.get(position)
        holder.binding.setVariable(bindingVariable, item)
    }
}