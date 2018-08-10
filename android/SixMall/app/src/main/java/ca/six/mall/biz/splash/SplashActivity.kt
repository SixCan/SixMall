package ca.six.mall.biz.splash

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Message
import ca.six.mall.R
import ca.six.mall.biz.home.HomeActivity
import ca.six.mall.core.BaseActivity
import ca.six.mall.databinding.ActivitySplashBinding
import ca.six.mall.util.nav

class SplashActivity : BaseActivity() {
    val ACTION_ID_SPLASH_DONE = 11
    val DURATION_SPLASH = 6000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val binding = ActivitySplashBinding.inflate(layoutInflater)
        val viewModel : SplashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        binding.vm = viewModel

        viewModel.init()

        println("szw:${binding.tvSplash.text}")
        println("szw:${viewModel.desp.get()}")
        // TODO rever it back
//        handler.sendEmptyMessageDelayed(ACTION_ID_SPLASH_DONE, DURATION_SPLASH)

    }

    val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == ACTION_ID_SPLASH_DONE) {
                this@SplashActivity.nav(HomeActivity::class.java)
                this@SplashActivity.finish()
            }
        }
    };

    override fun onDestroy() {
        handler.removeMessages(ACTION_ID_SPLASH_DONE)
        super.onDestroy()
    }
}
