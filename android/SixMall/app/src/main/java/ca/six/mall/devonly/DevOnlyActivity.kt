package ca.six.mall.devonly

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import ca.six.mall.R
import ca.six.mall.databinding.ActivityDevOnlyRvBinding
import kotlinx.android.synthetic.main.activity_dev_only_rv.*

class DevOnlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDevOnlyRvBinding>(this, R.layout.activity_dev_only_rv)
        val viewModel : DevOnlyRvViewModel = ViewModelProviders.of(this).get(DevOnlyRvViewModel::class.java)
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        viewModel.init()

    }

}