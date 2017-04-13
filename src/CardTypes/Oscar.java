package CardTypes;

public class Oscar extends Card{
	private final String COLOR;
	private final String SPECIAL = "Choose who to draw 2";
	
	public Oscar(String color){
		COLOR = color;
	}
	
	public String toString(){
		return SPECIAL  + " - " + COLOR;
	}
}
