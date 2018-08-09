package ca.six.mall.core.http

import android.os.Handler
import okhttp3.*
import java.io.IOException


object HttpEngine {
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

    fun request(apiName: String, mainThreadHandler : Handler, onResp : (respStr : String) -> Unit) {
        val req = Request.Builder()
                .url(PREFIX + apiName)
                .build()
        http.newCall(req).enqueue( object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("szw err = $e") //TODO 后续可以统一处理请求过程中的failure
            }

            override fun onResponse(call: Call, resp: Response) {
                val respStr =  resp .body()?.string() ?: "" // 三目运算符
                mainThreadHandler.post{ onResp(respStr) }
            }

        })

    }

}