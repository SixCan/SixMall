package ca.six.mall.util

import android.support.test.espresso.IdlingResource

class SleepIdler(val page: String, val sleepTime: Long) : IdlingResource {
    private var start: Long
    lateinit var resCallback: IdlingResource.ResourceCallback

    init {
        start = System.currentTimeMillis()
    }

    override fun getName(): String {
        return "SleepIdler_${page}_$sleepTime"
    }

    // Returns true if resource is currently idle. (idle就是指不用等待了, 可以继续干活了)
    override fun isIdleNow(): Boolean {
        val now = System.currentTimeMillis()
        val isOver = (now - start) > sleepTime
        if (isOver) {
            resCallback.onTransitionToIdle()
        }
        return isOver
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        this.resCallback = callback
    }
}