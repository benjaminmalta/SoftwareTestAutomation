package ws4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ws4.BallPosition.Colour;

public class BallPositionTest {

	@Test
	public void testGreenPosition() {
		BallPosition ballPos = new BallPosition(0);
		assertEquals(Colour.GREEN, ballPos.getColour(), "zero returns green");
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 })
	public void parameterizedBlackPositions(int number) {
		BallPosition ballPos = new BallPosition(number);
		assertEquals(Colour.BLACK, ballPos.getColour(), "When number is " + number + " the result should be BLACK");
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,3,7,9,12,14,16,18,21,23,25,27,30,32,34,36})
	public void paramaterizedRedPositions(int number) {
		BallPosition ballPos = new BallPosition(number);
		assertEquals(Colour.RED, ballPos.getColour(), "When number is " + number + " the result should be RED");
	}

}
