package varargs;

import java.util.ArrayList;
import java.util.List;

public class FilterApple {

	public static void prettyPrintApple(List<Apple> inventory,ApplePrint print) {
		for(Apple apple: inventory) {
			String output = print.printApple(apple);
			System.out.println(output);
		}
	}
}
