package CardTypes;

public class BabyBear extends Card{
	private final String COLOR;
	private final int NUMBER = 5;
	
	public BabyBear(String color){
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
