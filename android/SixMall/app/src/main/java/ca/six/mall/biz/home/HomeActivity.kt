package ca.six.mall.biz.home

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.R
import ca.six.mall.core.BaseActivity
import ca.six.mall.data.event.LoginEvent
import ca.six.mall.data.event.LogoutEvent
import ca.six.mall.databinding.ActivityHomeBinding
import com.thejoyrun.router.RouterActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@RouterActivity("home")
class HomeActivity : BaseActivity() {
    private val SOLAR_IN_RV_POSITION = 0

    private lateinit var binding: ActivityHomeBinding
    lateinit var viewModel : HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.rvHome.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.view = this
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        EventBus.getDefault().register(this)

        viewModel.init()

    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LoginEvent) {
        binding.rvHome.adapter.notifyItemChanged(SOLAR_IN_RV_POSITION)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LogoutEvent) {
        binding.rvHome.adapter.notifyItemChanged(SOLAR_IN_RV_POSITION)
    }


}