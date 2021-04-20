package apidemo;

import java.io.IOException;

public class App {

	public double getAverageCalories(String foodName) {
		DataLayer dataLayer = new DataLayer();
		LogicLayer logicLayer = new LogicLayer(dataLayer);
		return logicLayer.getAverageCalories(foodName);
		
	}
	
	public static void main(String[]args) throws IOException {
		DataLayer dataLayer = new DataLayer();
		App app = new App();
		System.out.println(app.getAverageCalories("Burger"));
	}
}

