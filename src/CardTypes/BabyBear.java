package CardTypes;

public class BabyBear extends Card implements Comparable{
	private final String COLOR;
	private final int NUMBER = 5;
	
	public BabyBear(String color){
		COLOR = color;
	}
	
	public String toString(){
		return  NUMBER + " - " + COLOR;
	}

	@Override
	public int compareTo(Object card) {
		// FIXME
		if(card instanceof Card){
			
			
			return -1;
		}else{
			return -1;
		}
	}
}
