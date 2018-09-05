package ca.six.mall.data.entity

import org.json.JSONArray
import org.json.JSONObject
import java.util.*


class RecommendationsItem(json: JSONObject) {
    var id: Long = 0
    var pic: String = ""
    var title: String = ""

    init {
        id = json.optLong("id")
        pic = json.optString("pic")
        title = json.optString("title")
    }

}

fun createRecommendationsItem(array: JSONArray): ArrayList<RecommendationsItem> {
    val list = ArrayList<RecommendationsItem>()
    val len = array.length()

    for (i in 0 until len) {
        val obj = array.optJSONObject(i)
        val oneItem = RecommendationsItem(obj)
        list.add(oneItem)
    }

    return list
}

