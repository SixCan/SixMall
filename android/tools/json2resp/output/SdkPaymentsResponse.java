package your.company.requests;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkPaymentsResponse {
	public String hotkey;
	public ArrayList<RecommendationsItem> recommendations;

	public SdkPaymentsResponse (String jsonStr){
		if(!TextUtils.isEmpty(jsonStr)){
			try{
				JSONObject json = new JSONObject(jsonStr);
				hotkey = json.optString("hotkey");

				JSONArray array = json.optJSONArray("recommendations");
				recommendations = RecommendationsItem.createWithJsonArray(array);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
