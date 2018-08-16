package ca.six.mall.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.squareup.picasso.Picasso

object DataBindingEx {
    @BindingAdapter("app:url")
    @JvmStatic
    fun loadImage(iv: ImageView, url: String?) {
        Picasso.get()
                .load(url)
                .into(iv)
    }

    @BindingAdapter("app:data")
    @JvmStatic
    fun rvSetData(rv: RecyclerView, data : List<out Any>) {
        println("szw utils rvSetData()")
        data.forEach{ println("    ---   szw $it")}
    }
}