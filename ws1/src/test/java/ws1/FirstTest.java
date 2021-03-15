package ws1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FirstTest {
	
	@Test
	public void checkListSize() {
		assertEquals(2, HelloWorld.getStrings().size());
	}

}
