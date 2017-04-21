package CardTypes;

public class ErnieAndBert extends Card implements Special{
	private final String COLOR;
	private final String SPECIAL = "Draw 1";
	private final int NUMBER = 100;
	
	public ErnieAndBert(String color){
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
		return 1;
	}
}
