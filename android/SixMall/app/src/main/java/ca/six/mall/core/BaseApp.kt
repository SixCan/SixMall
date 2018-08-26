package ca.six.mall.core

import android.app.Application
import android.content.Context
import android.os.Handler
import ca.six.mall.SixMallEventBusIndex
import com.thejoyrun.router.Router
import org.greenrobot.eventbus.EventBus
import kotlin.properties.Delegates

class BaseApp : Application() {

    companion object {
        var appContext : Context by Delegates.notNull<Context>()
        val handler = Handler()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this

        Router.init("sixmall")  //router scheme

        // config EventBus. Adding indexes to make EventBus act more quickly
        EventBus.builder()
                .addIndex(SixMallEventBusIndex())
                .installDefaultEventBus()

    }
}