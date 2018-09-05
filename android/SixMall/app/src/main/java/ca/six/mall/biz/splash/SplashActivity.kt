package ca.six.mall.biz.splash

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Message
import ca.six.mall.R
import ca.six.mall.core.BaseActivity
import ca.six.mall.databinding.ActivitySplashBinding
import ca.six.mall.util.nav
import com.thejoyrun.router.Router
import com.thejoyrun.router.RouterActivity

@RouterActivity("splash")
class SplashActivity : BaseActivity() {
    private val ACTION_ID_SPLASH_DONE = 11
    @JvmField val DURATION_SPLASH = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        val viewModel : SplashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        viewModel.init()

        handler.sendEmptyMessageDelayed(ACTION_ID_SPLASH_DONE, DURATION_SPLASH)

    }

    val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == ACTION_ID_SPLASH_DONE) {
                nav(this@SplashActivity, "home")
                this@SplashActivity.finish()
            }
        }
    };

    override fun onDestroy() {
        handler.removeMessages(ACTION_ID_SPLASH_DONE)
        super.onDestroy()
    }
}
