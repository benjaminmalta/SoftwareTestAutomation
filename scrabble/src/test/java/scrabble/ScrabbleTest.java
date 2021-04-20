package scrabble;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScrabbleTest {

	private Scrabble scrabble;

	@BeforeEach
	public void initialiseScrabble() {
		scrabble = new Scrabble();
	}

	@Test
	public void testNullValueReturnsZero() {
		assertEquals(0, scrabble.getScore(null), "null=0");
	}

	@Test
	public void testEmptyStringReturnsZero() {
		assertEquals(0, scrabble.getScore(""), "Empty string = 0");
	}

	@Test
	public void testLowerCaseAlphabeticalString() {
		assertEquals(14, scrabble.getScore("cabbage"), "cabbage = 14");
	}
	@Test
	public void testMixedCaseAlphabeticalString() {
		assertEquals(14, scrabble.getScore("caBBage"), "cabbage = 14");
	}
	
	@Test
	public void testNonAlphabeticalStringReturnsZero() {
		assertEquals(0, scrabble.getScore("123##!"), "123##! = 0"  );
	}
	
	@Test
	public void testMixedAlphaAndNonAlpha() {
		assertEquals(14, scrabble.getScore("123##!cabbage"), "123##!cabbage = 14");
	}
	
	@Test
	public void testAllAlphabet() {
		assertEquals(87, scrabble.getScore("abcdefghijklmnopqrstuvwxyz"), "all alphabet = 87");
	}
	
	
}
