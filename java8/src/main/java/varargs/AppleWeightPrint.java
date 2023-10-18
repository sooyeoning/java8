package varargs;

public class AppleWeightPrint implements ApplePrint{

	@Override
	public String printApple(Apple apple) {
		String characteristic = apple.getWeight()>150 ? "heavy" : "light";
		/* String weight="가볍다";
		if(apple.getWeight()>150) {
			weight="무겁다";
		} */
		return "An"+ characteristic + apple.getColor() + "apple";
	}

}
