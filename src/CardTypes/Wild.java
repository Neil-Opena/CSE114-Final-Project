package CardTypes;

public class Wild extends Card {
	private final int NUMBER = 400;
	private final String COLOR = null;

	public Wild() {

	}

	public String toString() {
		return "WILD CARD";
	}
	
	public int getNumber(){
		return NUMBER;
	}
	
	public String getColor(){
		return COLOR;
	}
	
}
