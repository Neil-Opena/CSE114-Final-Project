package CardTypes;

public class Rosita extends Card{
	private final String COLOR;
	private final int NUMBER = 6;
	
	public Rosita(String color){
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
