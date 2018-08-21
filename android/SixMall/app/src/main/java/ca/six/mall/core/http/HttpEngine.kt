package ca.six.mall.core.http

import android.support.annotation.WorkerThread
import ca.six.mall.core.BaseApp
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


object HttpEngine {
    val CODE_SUCCESS = 200

    // for dev-only
    var isMock = false
    var mockJson = ""

    // config info
    val PREFIX = "http://192.168.2.26:8899/"  // Node.js runs on my Mac

    val http: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .addInterceptor(MockResponseInterceptor())
                .build()
    }


    // kotlin比python好, 有默认值的参数不用在最后
    fun request(apiName: String,
                formData : RequestBody? = null,
                @WorkerThread onResp: (payload: JSONObject, errorCode : Int) -> Unit
                ) {
        val requestBuilder = Request.Builder()
                .url(PREFIX + apiName)

        if(formData != null){
            requestBuilder.post(formData)
        }

        val req = requestBuilder.build()

        http.newCall(req).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("szw err = $e") //TODO 后续可以统一处理请求过程中的failure
            }

            override fun onResponse(call: Call, resp: Response) {
                val respStr = resp.body()?.string() ?: "" // 三目运算符
                val respJson = JSONObject(respStr)

                val code = respJson.optInt("code")

                if(code == CODE_SUCCESS) {
                    val payload = respJson.opt("payload") as JSONObject
                    onResp(payload, CODE_SUCCESS)
                } else {
                    onResp(respJson, code)
                }
            }

        })

    }

}