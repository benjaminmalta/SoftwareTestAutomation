package ws4;


public class BallPosition {

	public enum Colour {
		GREEN, RED, BLACK
	}

	private int num;

	public BallPosition(int number) {
		this.num = number;
	}

	public int getNumber() {
		return num;
	}

	public Colour getColour() {
		
		if (!(num >= 0 && num <= 36))
			return null;
		
		if (num == 0)
			return Colour.GREEN;
		
		// Ranges 1 to 10 and 19 to 28
		if ((num >= 1 && num <= 10) || (num >= 19 && num <=28)) {
			if (num%2 == 0)
				return Colour.BLACK;
			else
				return Colour.RED;
		} else {
			if (num%2 == 0)
				return Colour.RED;
			else
				return Colour.BLACK;			
		}	
	}

}