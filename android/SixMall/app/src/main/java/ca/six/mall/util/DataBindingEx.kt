package ca.six.mall.util

import android.databinding.BindingAdapter
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
}