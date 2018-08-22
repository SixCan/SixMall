package ca.six.mall.biz.login

import android.arch.lifecycle.MutableLiveData
import ca.six.mall.core.auth.UserManager
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.data.event.SingleLiveEvent
import ca.six.mall.util.sha512
import okhttp3.FormBody
import org.json.JSONObject

class LoginViewModel {
    var userName = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    //思考了很久, 考虑到后面可能要支持config change. 所以在EventBus与SingleLiveEvent中选择了后者
    var loginSucc = SingleLiveEvent<Unit>()

    fun login() {
        val name = userName.value
        val pwd = password.value
        val pwdInSha = pwd?.sha512()

        val formData = FormBody.Builder()
                .add("name", name)
                .add("pwd", pwdInSha)
                .build()

        HttpEngine.request("login", formData) { payload : JSONObject->
            println("szw $payload")
            val sessionId = payload.optString("sessionId")
            UserManager.sessionId = sessionId
            loginSucc.call_()
        }
    }
}