package CardTypes;

public class Elmo extends Card {
	private final String COLOR;
	private final int NUMBER = 4;

	public Elmo(String color){
		COLOR = color;
	}
	
	public String toString(){
		return  NUMBER + " - " + COLOR;
	}
	
	public String getColor(){
		return COLOR;
	}
	
	public int getNumber(){
		return NUMBER;
	}
}
