package varargs;

public class Banana {
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
	
	public Banana(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
}
