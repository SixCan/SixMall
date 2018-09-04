package ca.six.mall.data.entity

import org.json.JSONObject
import java.util.*

class HomeResponse(json : JSONObject) {
    var hotkey: String = ""
    var recommendations = ArrayList<RecommendationsItem>()

    constructor(jsonStr : String) : this(JSONObject(jsonStr)){}

    init {
        hotkey = json.optString("hotkey")

        val array = json.optJSONArray("recommendations")
        recommendations = createRecommendationsItem(array)
    }

}

