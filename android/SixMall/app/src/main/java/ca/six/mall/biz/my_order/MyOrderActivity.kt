package ca.six.mall.biz.my_order

import android.databinding.DataBindingUtil
import android.os.Bundle
import ca.six.mall.R
import ca.six.mall.core.BaseActivity
import ca.six.mall.databinding.ActivityMyOrderBinding

class MyOrderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMyOrderBinding>(this, R.layout.activity_my_order)
        binding.vm = MyOrderViewModel()
        binding.setLifecycleOwner(this)
    }
}