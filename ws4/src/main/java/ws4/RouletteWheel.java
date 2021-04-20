package ws4;

import java.util.Random;

public class RouletteWheel {

	public static final int MIN = 0;
	public static final int MAX = 36;
	private Random random;

	public RouletteWheel() {
		random = new Random();
	}
	
	public BallPosition spin() {
		int num = random.nextInt(MAX+1);
		return new BallPosition(num);
	}

}