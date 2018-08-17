package ca.six.mall.util

import android.databinding.BindingAdapter
import android.support.annotation.MainThread
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import ca.six.mall.view.rv.one_binding.BindingRow
import ca.six.mall.view.rv.one_binding.OneBindingAdapter
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow
import ca.six.mall.view.rv.one_binding_types.OneBindingTypesAdapter
import com.squareup.picasso.Picasso

object DataBindingEx {
    @BindingAdapter("app:url")
    @JvmStatic
    @MainThread
    fun loadImage(iv: ImageView, url: String?) {
        Picasso.get()
                .load(url)
                .into(iv)
    }


    @BindingAdapter( "data", "row")
    @JvmStatic
    @MainThread
    fun <T> rvSetData(rv: RecyclerView, data: List<T>?, row : BindingRow?) {
        if (row != null) {
            val adapter = OneBindingAdapter<T>(row.layoutResId, row.bindingId, data)
            rv.adapter = adapter
        }
    }

    @BindingAdapter( "rows")
    @JvmStatic
    @MainThread
    fun rvSetRows(rv: RecyclerView, rows :  List<BindingTypesRow<*>>?) {
        if (rows != null){
            val adapter = OneBindingTypesAdapter(rows)
            rv.adapter = adapter
        }
    }
}