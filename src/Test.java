import java.util.*;
import CardTypes.*;

public class Test {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		CardDeck first = new CardDeck();
		Player human = new Player();
		Player computer = new Player();	
		
		//player draws card
		first.shuffle();
		System.out.print("Enter an integer (0 - 35):");
		int index = stdin.nextInt();
		stdin.nextLine();
		Card userHigh = first.getDeck()[index];
		human.setHighCard(userHigh);
		first.discard(index);
		
		//computer draws card
		int compIndex = (int) (Math.random() * first.getDeck().length);
		Card compHigh = first.getDeck()[compIndex];
		computer.setHighCard(compHigh);
		first.discard(compIndex);

		System.out.println("You drew: " + userHigh);
		System.out.println("Computer drew: " + compHigh);
		
		calculateFirst(human,computer).setTurn(true); //decide order
		//reshuffle remaining
		
		CardDeck deck = new CardDeck();
		deck.shuffle();
		deck.reverse();
		
		System.out.println("==================================");
		//five cards each
		for(int i = 0; i < 5; i++){
			Card card = deck.drawTop(); //draw
			human.addCard(card);//add to player hand
			deck.discard(0);//discard card , will always be at the top\
			
			//repeat for computer
			card = deck.drawTop();
			computer.addCard(card);
			deck.discard(0);
		}
		
		printDeck(human);
		System.out.println("-----------------------------------");
		printDeck(computer);
		

	}
	
	public static void printDeck(Object deck){
		if(deck instanceof CardDeck){
			for(int i = 0; i < ((CardDeck) deck).getDeck().length; i++){
				System.out.println(((CardDeck) deck).getDeck()[i]);
			}
		}else if(deck instanceof Player){
			for(int i = 0; i < ((Player) deck).getHand().length; i++){
				System.out.println(((Player) deck).getHand()[i]);
			}
		}else if(deck instanceof DiscardPile){
			for(int i = 0; i < ((DiscardPile) deck).getDeck().length; i++){
				System.out.println(((DiscardPile) deck).getDeck()[i]);
			}
		}
		
	}
	
	public static Player calculateFirst(Player one, Player two){
		//FIXME
		//implement compareTO
		return one;
	}
	
}
