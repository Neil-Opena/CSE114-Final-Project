import java.util.*;
import CardTypes.*;

public class Test {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		CardDeck first = new CardDeck();
		Player human = new Player();
		Player computer = new Player();

		// player draws card
		first.shuffle();
		System.out.print("Enter an integer (0 - 35):");
		int index = stdin.nextInt();
		stdin.nextLine();
		Card userHigh = first.getDeck()[index];
		human.setHighCard(userHigh);
		first.discard(index);

		// computer draws card
		int compIndex = (int) (Math.random() * first.getDeck().length);
		Card compHigh = first.getDeck()[compIndex];
		computer.setHighCard(compHigh);
		first.discard(compIndex);

		System.out.println("You drew: " + userHigh);
		System.out.println("Computer drew: " + compHigh);
		
		Player temp = calculateFirst(human,computer);	
		if(temp == null){
			System.out.println("=============================");
			System.exit(0);
		}
		
		
		
		CardDeck deck = new CardDeck();
		deck.shuffle();
		deck.reverse();
		DiscardPile discard = new DiscardPile();

		System.out.println("==================================");
		// five cards each
		for (int i = 0; i < 5; i++) {
			Card card = deck.drawTop(); // draw
			human.addCard(card);// add to player hand
			deck.discard(0);// discard card , will always be at the top\

			// repeat for computer
			card = deck.drawTop();
			computer.addCard(card);
			deck.discard(0);
		}

		printDeck(human);
		System.out.println("-----------------------------------");
		printDeck(computer);
		System.out.println("-----------------------------------");
		if(human.getTurn()){
			System.out.println("You go first!");
		}else{
			System.out.println("Computer goes first!");
		}
		
		boolean finished = false;
		Card match = deck.drawTop(); //draw
		deck.discard(0);//discard 
		discard.addCard(match);
		System.out.print("\nCard to match: " + match);

	}

	public static void printDeck(Object deck) {
		if (deck instanceof CardDeck) {
			for (int i = 0; i < ((CardDeck) deck).getDeck().length; i++) {
				System.out.println(((CardDeck) deck).getDeck()[i]);
			}
		} else if (deck instanceof Player) {
			for (int i = 0; i < ((Player) deck).getHand().length; i++) {
				System.out.println(((Player) deck).getHand()[i]);
			}
		} else if (deck instanceof DiscardPile) {
			for (int i = 0; i < ((DiscardPile) deck).getDeck().length; i++) {
				System.out.println(((DiscardPile) deck).getDeck()[i]);
			}
		}

	}

	public static Player calculateFirst(Player one, Player two) {
		Card cardOne = one.getHighCard();
		Card cardTwo = two.getHighCard();
		
		if (cardOne.getNumber() == cardTwo.getNumber()) {
			System.out.println("Players both drew same value card");
			return null;
		} else if (cardOne.getNumber() > cardTwo.getNumber()) {
			return one;
		} else {
			return two;
		}
	}

	public static void switchTurn(Player one, Player two) {
		if(one.getTurn()){
			one.setTurn(false);
			two.setTurn(true);
		}else{
			one.setTurn(true);
			two.setTurn(false);
		}

	}

}
