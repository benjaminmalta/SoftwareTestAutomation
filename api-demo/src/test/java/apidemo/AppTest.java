package apidemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import apidemo.stups.FailStub;
import apidemo.stups.JsonStubs;

public class AppTest {

	@Test
	public void liveApiBurgerTest() {
		App app = new App();
		assertTrue(app.getAverageCalories("Burger") >= 368);
	}
	@Test
	public void failStubTest() {
		FailStub failStub = new FailStub();
		LogicLayer logicLayer = new LogicLayer(failStub);
		assertEquals(-1, logicLayer.getAverageCalories("???"), "Stub will always through exception hence -1 should be returned.");
		
	}
	
	@Test
	public void filteredJsonStubTest() {
		JsonStubs stub = new JsonStubs("src/test/resources/gorgonzola_filtered.json");
		LogicLayer logic = new LogicLayer(stub);
		assertEquals(170.664, logic.getAverageCalories("????"), "Using local file gorgonzola_filtered.json");
	}
	
	
}
