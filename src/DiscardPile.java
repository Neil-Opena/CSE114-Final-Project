import CardTypes.Card;

public class DiscardPile {
	private Card[] deck = new Card[1];
	
	public DiscardPile(){
		
	}
	
	public Card[] getDeck(){
		return deck;
	}
	
	public void addCard(Card card){
		if(deck[0] == null){
			add(card);
		}else{
			extend();
			add(card);
		}
	}
	
	private void add(Card card){
		deck[deck.length - 1] = card;
	}
	
	private void extend(){
		Card[] temp = new Card[deck.length + 1];
		for(int i = 0; i < deck.length; i++){
			temp[i] = deck[i];
		}
		deck = temp;
	}
	
	public void resize(){
		deck = new Card[1];
	}
}
