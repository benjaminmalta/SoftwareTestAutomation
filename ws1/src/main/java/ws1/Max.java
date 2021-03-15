package ws1;

public class Max {

	public static double find(String values) throws IllegalArgumentException {

		if (values == null)
			throw new IllegalArgumentException("Null value provided");
		else if (values.isEmpty() || values.equals(","))
			return 0;

		String[] tokens = values.split(",");

		double currentMax = Double.NEGATIVE_INFINITY;

		for (String token : tokens) {
			double numericValue = Double.parseDouble(token);

			if (currentMax < numericValue)
				currentMax = numericValue;
		}

//		try {
//			for (String token : tokens) {
//				double numericValue = Double.parseDouble(token);
//
//				if (currentMax < numericValue)
//					currentMax = numericValue;
//			}
//		} catch (NumberFormatException nfe) {
//			throw new IllegalArgumentException("Invalid value");
//		}

		return currentMax;

	}

	public static void main(String[] args) {
		System.out.println(find("Java"));
	}

}
