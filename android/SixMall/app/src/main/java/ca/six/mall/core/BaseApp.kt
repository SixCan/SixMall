package ca.six.mall.core

import android.app.Application
import android.content.Context
import android.os.Handler
import kotlin.properties.Delegates

class BaseApp : Application() {

    companion object {
        var appContext : Context by Delegates.notNull<Context>()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}