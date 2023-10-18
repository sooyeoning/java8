package varargs;

public class Apple {
	String color;
	int weight;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
}
