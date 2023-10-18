package varargs;

public class AppleColorPrint implements ApplePrint{

	@Override
	public String printApple(Apple apple) {
		return apple.getColor();
	}

}
