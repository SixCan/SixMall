package ca.six.mall.util

import android.databinding.BindingAdapter
import android.support.annotation.MainThread
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
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

    @BindingAdapter("app:data")
    @JvmStatic
    @MainThread
    fun rvSetData(rv: RecyclerView, data: List<out Any>?) {
        println("szw utils rvSetData() : ${Thread.currentThread().name}")
        if (data != null) {
            data.forEach { println("    ---   szw $it") }
        }
    }
}