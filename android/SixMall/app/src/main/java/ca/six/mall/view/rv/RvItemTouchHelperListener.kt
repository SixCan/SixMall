package ca.six.mall.view.rv

/**
 * Created by songzhw on 2016-06-09.
 */
interface RvItemTouchHelperListener {
    fun onMove(fromPosition: Int, toPosition: Int) {}
    fun onSwiped(position: Int) {}
    fun onFinishDrag(){}
}
