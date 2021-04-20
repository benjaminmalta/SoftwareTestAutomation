package apidemo;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogicLayer {

	private DataLayer dataLayer;

	public LogicLayer(DataLayer dataLayer) {
		this.dataLayer = dataLayer;
	}

	public double getAverageCalories(String foodName) {
		double totalCalories = 0.0;
		try {
			String json = dataLayer.getJsonResponse(foodName);
			JSONObject jsonResponse = new JSONObject(json);
			JSONArray hits = jsonResponse.getJSONArray("hits");
			for (int i = 0; i < hits.length(); i++) {
				JSONObject currentHit = hits.getJSONObject(i);
				JSONObject fields = currentHit.getJSONObject("fields");
				double calories = fields.getDouble("nf_calories");
				totalCalories += calories;
			}

			return totalCalories / hits.length();
		} catch (IOException e) {
			return -1;
		}

	}
}
