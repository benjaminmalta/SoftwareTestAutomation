package ws1;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	
	public static List<String> getStrings() {
		List<String> strings = new ArrayList<>();
		strings.add("Hello World");
		strings.add("This code requires at least Java 7");
		strings.add("Another string");
		return strings;
	}

	public static void main(String[] args) {
		System.out.println(getStrings());
	}

}
