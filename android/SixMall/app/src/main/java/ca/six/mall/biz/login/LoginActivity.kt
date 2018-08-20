package ca.six.mall.biz.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import ca.six.mall.R
import ca.six.mall.core.BaseActivity
import ca.six.mall.databinding.ActivityLoginBinding
import ca.six.mall.util.dp2px
import ca.six.tomato.util.getCircleBitmap
import ca.six.tomato.util.getVectorBitmap

class LoginActivity : BaseActivity() {
    val viewModel : LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.controller = this
        binding.vm = viewModel
        binding.setLifecycleOwner(this)

        val avatarSize = this.dp2px(60f).toInt()
        val originalAvata = getVectorBitmap(this, R.drawable.ic_avatar, avatarSize, avatarSize)
        val circleAvatar = getCircleBitmap(originalAvata, originalAvata.width / 2f)
        binding.ivAvatar.setImageBitmap(circleAvatar)
        originalAvata.recycle()
    }

    fun onLogin(view : View){
        viewModel.login()
    }

}