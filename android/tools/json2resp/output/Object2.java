package your.company.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Object2 {
	public String a;
	public String c;
	public String e;

	public Object2 (JSONObject json){
		if(json != null){
			a = json.optString("a");
			c = json.optString("c");
			e = json.optString("e");
		}
	}

	public static ArrayList<Object2> createWithJsonArray(JSONArray array) {
		if(array != null){
			int len = array.length();
			ArrayList<Object2> list = new ArrayList<Object2>();
			for(int i = 0 ; i < len ; i++){
				JSONObject obj = array.optJSONObject(i);
				Object2 oneItem = new Object2(obj);
				list.add(oneItem);
			}
			return list;
		}
		return null;
	}

}