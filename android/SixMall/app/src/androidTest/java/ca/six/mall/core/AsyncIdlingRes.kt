package ca.six.mall.core

import android.support.test.espresso.IdlingResource.ResourceCallback
import android.support.test.espresso.IdlingResource


/**
 * @author sonzhw
 * @date 2015/9/9
 */
class AsyncIdlingRes(private var flag: IIdlingFlag?) : IdlingResource {

    private var resourceCallback: ResourceCallback? = null

    fun removeListener() {
        flag = null
        resourceCallback = null
    }

    override fun getName(): String {
        return "AsyncIdlingRes"
    }

    override fun isIdleNow(): Boolean {
        val isIdleNow = flag!!.isFinish()
        if (isIdleNow) {
            resourceCallback!!.onTransitionToIdle()
        }
        return isIdleNow
    }

    override fun registerIdleTransitionCallback(resourceCallback: ResourceCallback) {
        this.resourceCallback = resourceCallback
    }


}