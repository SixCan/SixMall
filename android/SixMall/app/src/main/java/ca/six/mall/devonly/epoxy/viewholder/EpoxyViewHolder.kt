package ca.six.mall.devonly.epoxy.viewholder

import android.support.annotation.DrawableRes
import android.support.v4.util.SparseArrayCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder

// 注意: EpoxyHolder类并不是ViewHolder的子类, 只是一个abstract类, 只有一个bindView()方法而已
class EpoxyViewHolder : EpoxyHolder() {

    private val views: SparseArrayCompat<View>
    lateinit var convertView : View

    init {
        views = SparseArrayCompat()
    }

    fun <T : View> getView(id: Int): T {
        var view: View? = views.get(id)
        if (view == null) {
            view = convertView.findViewById(id)
            views.put(id, view)
        }
        return view as T
    }

    override fun bindView(itemView: View) {
        convertView = itemView
    }

    // ============================================
    fun setText(id: Int, str: String) {
        val tv = getView<TextView>(id)
        tv.text = str
    }

    fun setSrc(id: Int, @DrawableRes drawId: Int) {
        val iv = getView<ImageView>(id)
        iv.setImageResource(drawId)
    }

    fun setBackground(id: Int, @DrawableRes bgResId: Int) {
        val view = getView<View>(id)
        view.setBackgroundResource(bgResId)
    }

    fun setClickListener(id: Int, listener: View.OnClickListener) {
        val view = getView<View>(id)
        view.setOnClickListener(listener)
    }

    fun setVisibility(id: Int, visibility: Int) {
        val view = getView<View>(id)
        view.visibility = visibility
    }

}