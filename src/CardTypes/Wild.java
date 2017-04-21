package CardTypes;

public class Wild extends Card {
	private final int NUMBER = 400;
	private String color = null;

	public Wild() {

	}

	public String toString() {
		return "WILD CARD";
	}
	
	public int getNumber(){
		return NUMBER;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
}
