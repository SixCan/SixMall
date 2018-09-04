package ca.six.mall.view.rv.one_binding_types

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ca.six.mall.view.rv.RvBindingViewHolder

class OneBindingTypesAdapter(private val rows: List<BindingTypesRow>)
    : RecyclerView.Adapter<RvBindingViewHolder>() {

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun getItemViewType(position: Int): Int {
        return rows[position].layoutResId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return RvBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvBindingViewHolder, position: Int) {
        val row = rows.get(position)
        for (detail in row.details){
            holder.binding.setVariable(detail.bindingId, detail.data)
        }
        holder.binding.executePendingBindings()
    }

}