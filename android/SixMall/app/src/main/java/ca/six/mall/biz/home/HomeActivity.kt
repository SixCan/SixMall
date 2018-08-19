package ca.six.mall.biz.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.biz.home.solar.SolarBindingRow
import ca.six.mall.core.BaseActivity
import ca.six.mall.databinding.ActivityDevOnlyTypesBinding
import ca.six.mall.databinding.ActivityHomeBinding
import ca.six.mall.devonly.pojo.DevOnlyPerson
import ca.six.mall.devonly.pojo.DevOnlyUser
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.rvHome.layoutManager = LinearLayoutManager(this)
        binding.view = this
        binding.setLifecycleOwner(this)


        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
    }

    fun rows(): List<BindingTypesRow<*>> {
        val list = ArrayList<BindingTypesRow<*>>()

        // solar menus
        list.add(SolarBindingRow(this, R.layout.item_solar_menus, BR.view, Unit))


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
}