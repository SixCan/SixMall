package ca.six.mall.data.entity

import org.json.JSONObject
import java.util.*

class HomeResponse(jsonStr: String) {
    var hotkey: String = ""
    var recommendations = ArrayList<RecommendationsItem>()

    init {
        val json = JSONObject(jsonStr)
        hotkey = json.optString("hotkey")

        val array = json.optJSONArray("recommendations")
        recommendations = createRecommendationsItem(array)
    }

}
