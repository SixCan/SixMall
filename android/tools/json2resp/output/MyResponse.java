package your.company.requests;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyResponse {
	public ArrayList<int> array2;
	public boolean boolean2;
	public String color2;
	public null null2;
	public int number2;
	public Object2 object2;
	public ArrayList<RecommendsItem> recommends;
	public String string2;

	public MyResponse (String jsonStr){
		if(!TextUtils.isEmpty(jsonStr)){
			try{
				JSONObject json = new JSONObject(jsonStr);

				JSONArray array = json.optJSONArray("array2");
				array2 = new ArrayList<int>();
				for(int i = 0; i < array.length(); i++){
					int asub = (int) array.opt(i);
					array2.add(asub);
				}
				boolean2 = json.optBoolean("boolean2");
				color2 = json.optString("color2");
				number2 = json.optInt("number2");

				JSONObject sub = json.optJSONObject("object2");
				object2 = new Object2(sub);


				JSONArray array = json.optJSONArray("recommends");
				recommends = RecommendsItem.createWithJsonArray(array);
				
				string2 = json.optString("string2");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
