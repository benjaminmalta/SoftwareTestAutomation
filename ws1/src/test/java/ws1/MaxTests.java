package ws1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MaxTests {
	
	@Test
	public void testSingleIntegerString() {
		assertEquals(1, Max.find("1"));
	}
	
	@Test
	public void testMultipleIntegerString() {
		assertEquals(55, Max.find("1,2,3,4,55"));
	}
	
	@Test
	public void testMultipleNumberString() {
		assertEquals(2.1, Max.find("2,2,2.1"));
	}
	
	@Test
	public void testSignedIntegerString() {
		assertEquals(6, Max.find("-5,6"));
	}
	
	@Test
	public void testNegativeIntegerString() {
		assertEquals(-2, Max.find("-2,-4,-9"));
	}
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Max.find(""));
	}
	
	@Test
	public void testCommaString() {
		assertEquals(0, Max.find(","));
	}
	
	@Test
	public void testNonNumericString() {
		assertThrows(IllegalArgumentException.class, () -> {
			Max.find("Java");
		});
	}
	
	@Test
	public void testMixedNumericString() {
		assertThrows(IllegalArgumentException.class, () -> {
			Max.find("1,2,3,four");
		});
	}
	
	@Test
	public void testNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Max.find(null);
		});
	}

}
