package CardTypes;

public class BigBird extends Card{
	private final String COLOR;
	private final int NUMBER = 1;
	
	public BigBird(String color){
		COLOR = color;
	}
	
	public String toString(){
		return  NUMBER + " - " + COLOR;
	}
}
