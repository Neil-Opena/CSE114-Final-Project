import CardTypes.*;

public class Player{
	private Card highCard;
	private Card[] hand = new Card[1];
	private boolean turn = false;
	private boolean drawOne = false;
	private boolean drawTwo = false;
	private boolean won = false;
	private boolean uno = false;
	
	public Player(){
		
	}
	
	public Card getHighCard(){
		return highCard;
	}
	
	public void setHighCard(Card highCard){
		this.highCard = highCard;
	}
	
	public boolean getTurn(){
		return turn;
	}
	
	public void setTurn(boolean turn){
		this.turn = turn;
	}
	
	public boolean getWon(){
		return won;
	}
	
	public void setWon(boolean a){
		won = a;
	}
	
	public boolean getUno(){
		return uno;
	}
	
	public void setUno(boolean a){
		uno = a;
	}
	
	
	public Card[] getHand(){
		return hand;
	}
	
	public void addCard(Card card){
		if(hand[0] == null){
			add(card);
		}else{
			//extend and add to it
			extend();
			add(card);
		}
	}
	
	public boolean getDrawOne(){
		return drawOne;
	}
	
	public void setDrawOne(boolean a){
		drawOne = a;
	}
	
	public boolean getDrawTwo(){
		return drawTwo;
	}
	
	public void setDrawTwo(boolean a){
		drawTwo = a;
	}
	
	public void discard(int index){
		hand[index] = null;
		resize();
	}
	
	public void resize(){
		Card[] temp = new Card[hand.length - 1];
		for(int i = 0, j = 0; i < hand.length; i++){
			if(hand[i] != null){
				temp[j] = hand[i];
				j++;
			}
		}
		
		hand = temp;
	}
	
	private void extend(){
		Card[] temp = new Card[hand.length + 1];
		for(int i = 0; i < hand.length;i++){
			temp[i] = hand[i];
		}
		hand = temp;
	}
	
	private void add(Card card){
		hand[hand.length - 1] = card;
	}

}
