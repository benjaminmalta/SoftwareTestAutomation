package ws1;

public class Calc {
	
	private int num1;
	private int num2;
	private char sign;
	
	public Calc() {
		
	}
	
	public Calc(int num1, int num2, char sign) {
		this.num1 = num1;
		this.num2 = num2;
		this.sign = sign;
	}
	
	// input = "5+3, num1=5, num2=3, sign=+, returns true"
	// input = "15-3, num1=15, num2=3, sign=-, returns true"
	public boolean parse(String input) {
		
		int signIndex;
		
		if (input == null || input.isEmpty())
			return false;
		else if ((signIndex = input.indexOf('/')) != -1)
			this.sign = '/';
		else if ((signIndex = input.indexOf('*')) != -1)
			this.sign = '*';
		else if ((signIndex = input.indexOf('+')) != -1)
			this.sign = '+';
		else if ((signIndex = input.indexOf('-')) != -1)
			this.sign = '-';
		else
			return false;
		
		
		try {
			String num1Str = input.substring(0, signIndex);
			String num2Str = input.substring(signIndex+1);
			this.num1 = Integer.parseInt(num1Str);
			this.num2 = Integer.parseInt(num2Str);
		} catch(NumberFormatException nfe) {
			return false;
		}
		
		return true;
	}
	
	public double getAnswer() {
		switch(sign) {
		case '+':
			return this.num1 + this.num2;
		case '-':
			return this.num1 - this.num2;
		case '*':
			return this.num1 * this.num2;
		case '/':
			if (num2 != 0)
				return this.num1 / (double)this.num2;			
		}
		return 0;
	}
	
	public String calculate(String inputString) {
		boolean parseResult = parse(inputString);
		if (parseResult)
			return this.num1 + " " + this.sign + " " + this.num2 + " = " + getAnswer();
		throw new IllegalArgumentException("Invalid input");		
	}
	

	@Override
	public String toString() {
		return "Calc [num1=" + num1 + ", num2=" + num2 + ", sign=" + sign + "]";
	}
	
	public static void main(String[] args) {
		Calc c = new Calc();
		String result = c.calculate(null);
		System.out.println(result);
	}
	

}
