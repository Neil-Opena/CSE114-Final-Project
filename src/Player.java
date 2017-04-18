import CardTypes.*;

public class Player{
	private Card highCard;
	private Card[] hand = new Card[1];
	private boolean turn = false;
	
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
