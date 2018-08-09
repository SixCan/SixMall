package ca.six.mall.core.http

import okhttp3.*
import java.io.IOException


object HttpEngine {
    // for dev-only
    var isMock = false
    var mockJson = ""

    // config info
    val PREFIX = " https://192.168.2.26:8899/"  // Node.js runs on my Mac

    val ERROR = "Error"
    val http: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .addInterceptor(MockResponseInterceptor())
                .build()
    }

    fun request(apiName: String) {
        val req = Request.Builder()
                .url(PREFIX + apiName)
                .build()
        http.newCall(req).enqueue( object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("szw err = $e")
            }

            override fun onResponse(call: Call?, resp: Response?) {
                val respStr =  resp ?.body()?.string() ?: "" // 三目运算符
                println("szw resp = $respStr")
            }

        })

    }

}