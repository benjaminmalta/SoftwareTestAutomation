package apidemo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataLayer {

	/**
	 * 
	 * @param foodName Name of food to be queried
	 * @return JSON string from the API
	 * @throws IOException if something goes wrong during the API call
	 */
	public String getJsonResponse(String foodName) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://nutritionix-api.p.rapidapi.com/v1_1/search/"+foodName+"?fields=nf_calories").get()
				.addHeader("x-rapidapi-key", "30296793f0msh474dd261353ae25p1e4039jsnb39ad416498e")
				.addHeader("x-rapidapi-host", "nutritionix-api.p.rapidapi.com").build();

		Response response = client.newCall(request).execute();

		return response.body().string();
	}
}
