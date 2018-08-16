package ca.six.mall.util

import android.databinding.BindingAdapter
import android.support.annotation.MainThread
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
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

    @BindingAdapter("app:data", "app:itemLayout", "app:")
    @JvmStatic
    @MainThread
    fun <T> rvSetData(rv: RecyclerView, data: List<T>, layoutResId : Int) {
        val adapter = OneBindingAdapter<T>(layoutResId, vari, data)
        rv.adapter = adapter
    }
}