import java.util.*;
import CardTypes.*;

public class Test {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		CardDeck first = new CardDeck();
		Player human = new Player();
		Player computer = new Player();

		while(true){
			Player temp = prep(first,human,computer);
			if(temp != null){
				temp.setTurn(true);
				break;
			}
		} //each player draws a card to decide order
		
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
	
		while(true){
			Card temp = deck.drawTop();
			deck.discard(0);
			discard.addCard(temp);
			if(discard.getDeck()[discard.getDeck().length - 1].getNumber() <= 7){
				System.out.println("Need to match: [ " + temp + " ]");
				break;
			}System.out.println("NOT VALID: [ " + temp + " ]");
		}
		
		System.out.println();
		if(human.getTurn()){
			System.out.println("You go first!");
		}else{
			System.out.println("Computer goes first!");
		}
		System.out.println();

		boolean won = false;
		while(!won){
			printDeck(human);
			System.out.println("Enter an integer (0 - " + (human.getHand().length - 1) + "):");
			int choice = stdin.nextInt();
			stdin.nextLine();
			Card playerCard = human.getHand()[choice];
			//TODO MAKE SPECIAL CARD IF STATEMENT FIRST
			if(playerCard.equals(discard.getDeck()[discard.getDeck().length - 1])){
				System.out.println("Need to match: [" + playerCard + " ]");
				human.discard(choice);//discard from hand
				discard.addCard(playerCard); //add to discard pile
			}else{ //add an else if for when it is a special card
				System.out.println("card did not match");
				break;
			}
			//when its a wild card, let the setColor method be called
			//when its a draw 1, change turn , force 1
			//when its a draw 2, change turn , force 2
		}
		//TODO make sure that discard pile is flipped later, or access it from beginning
		
		/*
		 * 
		 * FIRST TRY TO DO IT SO THAT TWO PLAYERS ARE PLAYING
		 * 
		 */
	}
	
	public static Player prep(CardDeck deck, Player one, Player two){
		Scanner stdin = new Scanner(System.in);
		deck.shuffle();
		System.out.print("Enter an integer (0 - 35):");
		int index = stdin.nextInt();
		stdin.nextLine();
		Card userHigh = deck.getDeck()[index];
		one.setHighCard(userHigh);
		deck.discard(index);

		// computer draws card
		int compIndex = (int) (Math.random() * deck.getDeck().length);
		Card compHigh = deck.getDeck()[compIndex];
		two.setHighCard(compHigh);
		deck.discard(compIndex);

		System.out.println("You drew: [ " + userHigh + " ]");
		System.out.println("Computer drew: [ " + compHigh + " ]");
		
		if(userHigh.getNumber() == compHigh.getNumber()){
			System.out.println("Players both drew same value card");
			return null;
		}else if(userHigh.getNumber() > compHigh.getNumber()){
			return one;
		}else{
			return two;
		}
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
