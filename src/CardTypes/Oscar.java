package CardTypes;

public class Oscar extends Card implements Special{
	private final String COLOR;
	private final int NUMBER = 200;
	private final String SPECIAL = "Choose who to draw 2";
	
	public Oscar(String color){
		COLOR = color;
	}
	
	public String toString(){
		return SPECIAL  + " - " + COLOR;
	}
	
	public String getColor(){
		return COLOR;
	}
	
	public int getNumber(){
		return NUMBER;
	}
	
	public int special(){
		return 2;
	}
}
