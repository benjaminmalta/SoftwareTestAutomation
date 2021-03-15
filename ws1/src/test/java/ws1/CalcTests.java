package ws1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalcTests {
	
	@Test
	public void testValidAddition() {
		Calc c = new Calc();
		String result = c.calculate("5+5");
		assertEquals("5 + 5 = 10.0", result);
	}
	
	@Test
	public void testValidSubtraction() {
		Calc c = new Calc();
		String result = c.calculate("5-3");
		assertEquals("5 - 3 = 2.0", result);
	}
	
	@Test
	public void testValidMultiplication() {
		Calc c = new Calc();
		String result = c.calculate("5*3");
		assertEquals("5 * 3 = 15.0", result);
	}
	
	@Test
	public void testValidDivision() {
		Calc c = new Calc();
		String result = c.calculate("11/2");
		assertEquals("11 / 2 = 5.5", result);
	}
	
	@Test
	public void testNullValue() {
		Calc c = new Calc();
		assertThrows(IllegalArgumentException.class, () -> {
			 c.calculate(null);
		});
	}
	
	

}
