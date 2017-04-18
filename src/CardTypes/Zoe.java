package CardTypes;

public class Zoe extends Card {
	private final String COLOR;
	private final int NUMBER = 2;

	public Zoe(String color) {
		COLOR = color;
	}

	public String toString() {
		return  NUMBER + " - " + COLOR;
	}
	
	public String getColor(){
		return COLOR;
	}
	
	public int getNumber(){
		return NUMBER;
	}
}
