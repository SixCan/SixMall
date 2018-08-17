package ca.six.mall.devonly

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.BR
import ca.six.mall.R
import ca.six.mall.databinding.ActivityDevOnlyRvBinding
import ca.six.mall.view.rv.one_binding.BindingRow

class DevOnlyRvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDevOnlyRvBinding>(this, R.layout.activity_dev_only_rv)
        val viewModel: DevOnlyRvViewModel = ViewModelProviders.of(this).get(DevOnlyRvViewModel::class.java)
        binding.rvDemo.layoutManager = LinearLayoutManager(this)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        viewModel.init()

    }

    fun row(): BindingRow {
        println("szw getRow()")
        return BindingRow(R.layout.item_dev_only_one, BR.user)
    }

}