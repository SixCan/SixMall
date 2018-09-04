package your.company.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendationsItem {
	public long id;
	public String pic;
	public String title;

	public RecommendationsItem (JSONObject json){
		if(json != null){
			id = json.optLong("id");
			pic = json.optString("pic");
			title = json.optString("title");
		}
	}

	public static ArrayList<RecommendationsItem> createWithJsonArray(JSONArray array) {
		if(array != null){
			int len = array.length();
			ArrayList<RecommendationsItem> list = new ArrayList<RecommendationsItem>();
			for(int i = 0 ; i < len ; i++){
				JSONObject obj = array.optJSONObject(i);
				RecommendationsItem oneItem = new RecommendationsItem(obj);
				list.add(oneItem);
			}
			return list;
		}
		return null;
	}

}