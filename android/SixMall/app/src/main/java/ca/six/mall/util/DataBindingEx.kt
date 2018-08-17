package ca.six.mall.util

import android.databinding.BindingAdapter
import android.support.annotation.MainThread
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import ca.six.mall.view.rv.one_binding.BindingRow
import ca.six.mall.view.rv.one_binding.OneBindingAdapter
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

    @BindingAdapter( "row")
    @JvmStatic
    @MainThread
    fun rvSetRow(rv : RecyclerView, row : BindingRow?){
        println("szw rvSetRow : row = ${row}")
    }

    @BindingAdapter( "data")
    @JvmStatic
    @MainThread
    fun <T> rvSetData(rv: RecyclerView, data: List<T>?) {
        println("szw rvSetData : data=${data}}")
//        if (row != null) {
//            val adapter = OneBindingAdapter<T>(row.layoutResId, row.bindingId, data)
//            rv.adapter = adapter
//        }
    }
}