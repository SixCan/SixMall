package ca.six.mall.view.rv

import android.app.Service
import android.os.Vibrator
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by songzhw on 2016-06-09.
 */
abstract class OnRvItemClickListener(private val rv: RecyclerView) : RecyclerView.OnItemTouchListener {
    private val gestureDetector: GestureDetectorCompat
    private val vibrator: Vibrator

    init {
        gestureDetector = GestureDetectorCompat(rv.context, RvGestureListener())
        vibrator = rv.context.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
    }

    private inner class RvGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onLongPress(e: MotionEvent) {
            // TODO maybe vibrate

            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null) {
                val vh = rv.getChildViewHolder(child)
                onLongClick(vh)
            }
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null) {
                val vh = rv.getChildViewHolder(child)
                onItemClick(vh)
            }
            return true //@return true if the event is consumed, else false
        }
    }

    // ========================= OnItemTouchListener =================================
    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(e)
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        gestureDetector.onTouchEvent(e)
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

    // ========================= abstract methods =================================
    abstract fun onLongClick(vh: RecyclerView.ViewHolder)

    abstract fun onItemClick(vh: RecyclerView.ViewHolder)

}
