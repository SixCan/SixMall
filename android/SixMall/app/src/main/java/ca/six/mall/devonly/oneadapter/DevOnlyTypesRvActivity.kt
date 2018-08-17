package ca.six.mall.devonly.oneadapter

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.databinding.ActivityDevOnlyRvBinding
import ca.six.mall.databinding.ActivityDevOnlyTypesBinding
import ca.six.mall.devonly.pojo.DevOnlyPerson
import ca.six.mall.devonly.pojo.DevOnlyUser
import ca.six.mall.view.rv.one_binding_types.BindingTypesRow

class DevOnlyTypesRvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDevOnlyTypesBinding>(this, R.layout.activity_dev_only_types)
        binding.rvDemoTypes.layoutManager = LinearLayoutManager(this)
        binding.view = this
        binding.setLifecycleOwner(this)
    }

    fun rows(): List<BindingTypesRow<*>> {
        val list = ArrayList<BindingTypesRow<*>>()
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyUser("Adam", 2000)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyUser("Eva", 2000)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyPerson(20, "szw", true)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyPerson(10, "xx", false)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyPerson(10, "dd", false)))
        list.add(BindingTypesRow(R.layout.item_dev_only_one, BR.user, DevOnlyUser("test", 1000)))
        return list
    }
}