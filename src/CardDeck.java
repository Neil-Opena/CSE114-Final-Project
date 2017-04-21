import CardTypes.*;

public class CardDeck {
	private Card[] deck = new Card[36];
	
	public CardDeck(){
		reset();
	}
	
	public Card[] getDeck(){
		return deck;
	}
	
	public void reset(){
		//BigBird
		deck[0] = new BigBird("red");
		deck[1] = new BigBird("yellow");
		deck[2] = new BigBird("blue");
		deck[3] = new BigBird("green");
		
		//Zoe
		deck[4] = new Zoe("red");
		deck[5] = new Zoe("yellow");
		deck[6] = new Zoe("blue");
		deck[7] = new Zoe("green");
		
		//CookieMonster
		deck[8] = new CookieMonster("red");
		deck[9] = new CookieMonster("yellow");
		deck[10] = new CookieMonster("blue");
		deck[11] = new CookieMonster("green");
		
		//Elmo
		deck[12] = new Elmo("red");
		deck[13] = new Elmo("yellow");
		deck[14] = new Elmo("blue");
		deck[15] = new Elmo("green");
		
		//BabyBear
		deck[16] = new BabyBear("red");
		deck[17] = new BabyBear("yellow");
		deck[18] = new BabyBear("blue");
		deck[19] = new BabyBear("green");
		
		//Rosita
		deck[20] = new Rosita("red");
		deck[21] = new Rosita("yellow");
		deck[22] = new Rosita("blue");
		deck[23] = new Rosita("green");
		
		//Grover
		deck[24] = new Grover("red");
		deck[25] = new Grover("yellow");
		deck[26] = new Grover("blue");
		deck[27] = new Grover("green");
		
		//ErnieAndBert
		deck[28] = new ErnieAndBert("red");
		deck[29] = new ErnieAndBert("blue");
		
		//Oscar
		deck[30] = new Oscar("yellow");
		deck[31] = new Oscar("green");
		
		//Wild
		deck[32] = new Wild();
		deck[33] = new Wild();
		deck[34] = new Wild();
		deck[35] = new Wild();
	}
	
	public void shuffle(){
		//Shuffling two different ways
		for(int i = 0; i < deck.length; i++){
			int indexFirst = (int) (Math.random() * deck.length);
			int indexSecond = (int) (Math.random() * deck.length);
			Card temp = deck[indexFirst];
			deck[indexFirst] = deck[indexSecond];
			deck[indexSecond] = temp;
		}
		
		for(int i = 0; i < deck.length; i++){
			int index = (int)(Math.random() * deck.length);
			Card temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
	}
	
	public void discard(int index){
		deck[index] = null;
		resize();
	}
	
	public void reverse(){
		Card[] temp = new Card[deck.length];
		for(int i = 0, j = deck.length - 1; i < deck.length; i++, j--){
			temp[i] = deck[j];
		}
		deck = temp;
	}
	
	public Card drawTop(){
		return deck[0];
	}
	
	private void resize(){
		Card[] temp = new Card[deck.length - 1];
		for(int i = 0, j = 0; i < deck.length; i++){
			if(deck[i] != null){
				temp[j] = deck[i];
				j++;
			}
		}
		
		deck = temp;
	}

	
}
