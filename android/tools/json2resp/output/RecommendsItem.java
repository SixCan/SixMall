package your.company.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendsItem {
	public long id;
	public Id_model id_model;
	public ArrayList<int> next;
	public String pic;
	public ArrayList<SubsItem> subs;

	public RecommendsItem (JSONObject json){
		if(json != null){
			id = json.optLong("id");
			id_model = json.optId_model("id_model");
			JSONArray ary = json.optJSONArray("next");
			int size = ary.length();
			next = new ArrayList<>();
			for (int i = 0 ; i < size ; i++) {
				next.add(ary.optInt(i));
				}
			pic = json.optString("pic");
			JSONArray ary = json.optJSONArray("subs");
			int size = ary.length();
			subs = new ArrayList<>();
			for (int i = 0 ; i < size ; i++) {
				subs.add(ary.optSubsItem(i));
				}
		}
	}

	public static ArrayList<RecommendsItem> createWithJsonArray(JSONArray array) {
		if(array != null){
			int len = array.length();
			ArrayList<RecommendsItem> list = new ArrayList<RecommendsItem>();
			for(int i = 0 ; i < len ; i++){
				JSONObject obj = array.optJSONObject(i);
				RecommendsItem oneItem = new RecommendsItem(obj);
				list.add(oneItem);
			}
			return list;
		}
		return null;
	}

}