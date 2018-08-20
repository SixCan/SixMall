package ca.six.mall.biz.login

import android.arch.lifecycle.MutableLiveData

class LoginViewModel {
    var userName = MutableLiveData<String>()
    var password = MutableLiveData<String>()
}