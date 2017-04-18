package CardTypes;

public class CookieMonster extends Card {
	private final String COLOR;
	private final int NUMBER = 3;

	public CookieMonster(String color){
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
