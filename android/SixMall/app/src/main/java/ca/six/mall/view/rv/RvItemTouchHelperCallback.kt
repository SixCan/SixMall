package ca.six.mall.view.rv

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import ca.six.mall.view.rv.RvItemTouchHelperListener

/**
 * Created by songzhw on 2016-06-09.
 */
class RvItemTouchHelperCallback(var listener: RvItemTouchHelperListener) : ItemTouchHelper.Callback() {


    // ========================= ItemTouchHelper.Callback (Basic) =================================
    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        var swipeFlags = 0
        val dragFlags: Int
        if (recyclerView.layoutManager is GridLayoutManager) {
            dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        } else {
            dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        }
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        listener.onMove(fromPosition, toPosition)
        return true
    }


    // ========================= ItemTouchHelper.Callback (drag & drop) =================================

    // when selected, show different background color
    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder!!.itemView.setBackgroundColor(0x33cccccc)
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    // back to normal (Called by the ItemTouchHelper when the user interaction with an element is over and it also completed its animation.)
    override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.setBackgroundColor(0)
    }


    // ========================= ItemTouchHelper.Callback (swipe)  =================================

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        listener.onSwiped(position)
    }

    //TODO when swiped, show different alpha
//    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
//    }

    // ========================= ItemTouchHelper.Callback (others)  =================================
//    override fun isLongPressDragEnabled(): Boolean {
//        return super.isLongPressDragEnabled() // true
//    }
//
//    override fun isItemViewSwipeEnabled(): Boolean {
//        return super.isItemViewSwipeEnabled() // true
//    }

}