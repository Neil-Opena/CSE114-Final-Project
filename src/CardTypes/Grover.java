package CardTypes;

public class Grover extends Card{
	private final String COLOR;
	private final int NUMBER = 7;
	
	public Grover(String color){
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
