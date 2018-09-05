package ca.six.mall.util

import android.support.test.espresso.IdlingResource

class SleepIdler(val page : String, val sleepTime : Long) : IdlingResource {
    private var start: Long
    lateinit var resCallback : IdlingResource.ResourceCallback

    init {
        start = System.currentTimeMillis()
    }

    override fun getName(): String {
        return "SleepIdler_${page}_$sleepTime"
    }

    // Returns true if resource is currently idle.
    override fun isIdleNow(): Boolean {
        val now = System.currentTimeMillis()
        if( (now - start) > sleepTime){
            resCallback.onTransitionToIdle()
            return true
        }
        return false
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        this.resCallback = callback
    }
}