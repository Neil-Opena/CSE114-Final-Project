package CardTypes;

public class ErnieAndBert extends Card{
	private final String COLOR;
	private final String SPECIAL = "Draw 1";
	
	public ErnieAndBert(String color){
		COLOR = color;
	}
	
	public String toString(){
		return SPECIAL  + " - " + COLOR;
	}
}
