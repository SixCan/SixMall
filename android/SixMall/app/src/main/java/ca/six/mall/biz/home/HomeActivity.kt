package ca.six.mall.biz.home

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.biz.home.solar.SolarController
import ca.six.mall.core.BaseActivity
import ca.six.mall.data.event.LoginEvent
import ca.six.mall.data.event.LogoutEvent
import ca.six.mall.databinding.ActivityHomeBinding
import ca.six.mall.devonly.pojo.DevOnlyPerson
import ca.six.mall.devonly.pojo.DevOnlyUser
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow
import com.thejoyrun.router.RouterActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@RouterActivity("home")
class HomeActivity : BaseActivity() {
    private val SOLAR_IN_RV_POSITION = 0

    private lateinit var binding: ActivityHomeBinding
    private lateinit var solarController: SolarController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.rvHome.layoutManager = LinearLayoutManager(this)
        val viewModel: HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.view = this
        //TODO
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

    fun rows(): List<BindingTypesRow<*>> {
        val list = ArrayList<BindingTypesRow<*>>()

        // solar menus
        solarController = SolarController(this)
        list.add(BindingTypesRow(R.layout.item_solar_menus, BR.controller, solarController))



        list.add(BindingTypesRow(R.layout.item_dev_only_person, BR.person, DevOnlyPerson(20, "szw", true)))
        list.add(BindingTypesRow(R.layout.item_dev_only_person, BR.person, DevOnlyPerson(10, "xx", false)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyUser("Adam", 2000)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyUser("Eva", 2000)))
        list.add(BindingTypesRow(R.layout.item_dev_only_person, BR.person, DevOnlyPerson(10, "dd", false)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyUser("test", 1000)))
        list.add(BindingTypesRow(R.layout.item_dev_only_person, BR.person, DevOnlyPerson(20, "szw", true)))
        list.add(BindingTypesRow(R.layout.item_dev_only_person, BR.person, DevOnlyPerson(10, "xx", false)))
        list.add(BindingTypesRow(R.layout.item_dev_only_person, BR.person, DevOnlyPerson(10, "dd", false)))
        return list
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LoginEvent) {
        solarController.isLogin = true
        binding.rvHome.adapter.notifyItemChanged(SOLAR_IN_RV_POSITION)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LogoutEvent) {
        solarController.isLogin = false
        binding.rvHome.adapter.notifyItemChanged(SOLAR_IN_RV_POSITION)
    }


}