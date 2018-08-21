package ca.six.mall.biz.login

import android.arch.lifecycle.MutableLiveData
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.util.sha512
import okhttp3.FormBody

class LoginViewModel {
    var userName = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun login() {
        val name = userName.value
        val pwd = password.value
        val pwdInSha = pwd?.sha512()

        val formData = FormBody.Builder()
                .add("name", name)
                .add("pwd", pwdInSha)
                .build()

        HttpEngine.request("login", formData) { payload ->
            println("szw loginVm $payload")
        }
    }
}