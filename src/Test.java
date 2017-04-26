import java.util.*;
import CardTypes.*;

public class Test {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		CardDeck first = new CardDeck();
		first.reset();
		Player human = new Player();
		Player computer = new Player();

		while (true) {
			Player temp = prep(first, human, computer);
			if (temp != null) {
				temp.setTurn(true);
				break;
			}
		} // each player draws a card to decide order

		CardDeck deck = new CardDeck();
		deck.reset();
		deck.shuffle();
		deck.reverse();
		DiscardPile discard = new DiscardPile();

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

		System.out.println();

		System.out.println("Your cards");
		printDeck(human);
		System.out.println("Computer cards");
		printDeck(computer);

		while (true) {
			Card temp = deck.drawTop();
			deck.discard(0);
			discard.addCard(temp);
			if (discard.getDeck()[discard.getDeck().length - 1].getNumber() <= 7) {
				break;
			}
			System.out.println("NOT VALID: [ " + temp + " ]");
		}

		System.out.println();

		boolean gameOver = false;

		while (!gameOver) {
			Card matchCard = discard.getDeck()[discard.getDeck().length - 1];
			if (matchCard instanceof Wild) {
				System.out.println("NEED TO MATCH: [ " + matchCard + "- " + matchCard.getColor() + " ]");
			} else {
				System.out.println("NEED TO MATCH: [ " + matchCard + " ]");
			}
			// TODO implement "UNO" part
			if (human.getTurn()) {
				if (human.getDrawOne()) {
					checkDeck(deck, discard, 1);
					Card card = deck.drawTop();
					human.addCard(card);
					deck.discard(0);
					human.setDrawOne(false);
					// forfeit turn
					switchTurn(human, computer);
					System.out.println("-----you draw one card and forfeit turn-----");
					continue;
				} else if (human.getDrawTwo()) {
					checkDeck(deck, discard, 2);
					for (int i = 0; i < 2; i++) {
						Card card = deck.drawTop();
						human.addCard(card);
						deck.discard(0);
					}
					human.setDrawTwo(false);
					// forfeit turn
					switchTurn(human, computer);
					System.out.println("-----you draw two cards and forfeit turn-----");
					continue;
				}

				System.out.println("\nYour turn\n");
				printDeck(human);
				System.out.println("Enter an integer (0 - " + (human.getHand().length - 1) + "):");
				int choice = stdin.nextInt();
				stdin.nextLine();
				Card playerCard = human.getHand()[choice];

				if (playerCard instanceof Wild) {
					System.out.println("Enter color to switch: ");
					String color = stdin.nextLine();
					((Wild) playerCard).setColor(color);
					human.discard(choice);
					discard.addCard(playerCard);
				} else if (playerCard.equals(discard.getDeck()[discard.getDeck().length - 1])) {
					human.discard(choice);// discard from hand
					discard.addCard(playerCard); // add to discard pile
					if (playerCard instanceof ErnieAndBert) {
						System.out.println("Computer draws 1 card");
						computer.setDrawOne(true);
					} else if (playerCard instanceof Oscar) {
						System.out.println("Computer draws 2 cards");
						computer.setDrawTwo(true);
					}
				} else { // add an else if for when it is a special card
					System.out.println("card did not match");
					// TODO
					checkDeck(deck, discard, 1);
					Card card = deck.drawTop();
					human.addCard(card);
					deck.discard(0);
					System.out.println("Drew: [ " + card + " ]");
					// check if card can be placed?
					System.out.println("Play Card (YES/NO):");
					String response = stdin.nextLine();
					if (response.equals("YES")) {
						if (card instanceof Wild) {
							System.out.println("Enter color to switch: ");
							String color = stdin.nextLine();
							((Wild) card).setColor(color);
							human.discard(choice);
							discard.addCard(card);
						} else if (card.equals(discard.getDeck()[discard.getDeck().length - 1])) {
							human.discard(choice);// discard from hand
							discard.addCard(card); // add to discard pile
							if (card instanceof ErnieAndBert) {
								System.out.println("Computer draws 1 card");
								computer.setDrawOne(true);
							} else if (card instanceof Oscar) {
								System.out.println("Computer draws 2 cards");
								computer.setDrawTwo(true);
							}
						}

					}

				}
				if (human.getHand().length == 0) {
					human.setWon(true);
					gameOver = true;
				}
				switchTurn(human, computer);
			} else {
				// computer turn:
				// iterate through all of the cards to see if anything
				// matches..first regular cards
				// then special cards
				if (computer.getDrawOne()) {
					checkDeck(deck, discard, 1);
					Card card = deck.drawTop();
					computer.addCard(card);
					deck.discard(0);
					computer.setDrawOne(false);
					// forfeit turn
					System.out.println("-----computer draws one card and forfeit turn-----");
					switchTurn(human, computer);
					continue;
				} else if (computer.getDrawTwo()) {
					checkDeck(deck, discard, 2);
					for (int i = 0; i < 2; i++) {
						Card card = deck.drawTop();
						computer.addCard(card);
						deck.discard(0);
					}
					computer.setDrawTwo(false);
					// forfeit turn
					System.out.println("-----computer draws two cards and forfeit turn-----");
					switchTurn(human, computer);
					continue;
				}
				System.out.println("\nComputer turn\n");
				printDeck(computer);
				System.out.println("Enter an integer (0 - " + (computer.getHand().length - 1) + "):");
				int choice = stdin.nextInt();
				stdin.nextLine();
				Card playerCard = computer.getHand()[choice];

				if (playerCard instanceof Wild) {
					System.out.println("Enter color to switch: ");
					String color = stdin.nextLine();
					((Wild) playerCard).setColor(color);
					computer.discard(choice);
					discard.addCard(playerCard);
				} else if (playerCard.equals(discard.getDeck()[discard.getDeck().length - 1])) {
					computer.discard(choice);// discard from hand
					discard.addCard(playerCard); // add to discard pile
					if (playerCard instanceof ErnieAndBert) {
						System.out.println("You draw 1 card");
						human.setDrawOne(true);
					} else if (playerCard instanceof Oscar) {
						System.out.println("You draw 2 cards");
						human.setDrawTwo(true);
					}
				} else {
					System.out.println("card did not match");
					// TODO
					checkDeck(deck, discard, 1);
					Card card = deck.drawTop();
					computer.addCard(card);
					deck.discard(0);
					System.out.println("Drew: [ " + card + " ]");
					System.out.println("Play Card (YES/NO):");
					String response = stdin.nextLine();
					if (response.equals("YES")) {
						if (card instanceof Wild) {
							System.out.println("Enter color to switch: ");
							String color = stdin.nextLine();
							((Wild) card).setColor(color);
							human.discard(choice);
							discard.addCard(card);
						} else if (card.equals(discard.getDeck()[discard.getDeck().length - 1])) {
							human.discard(choice);// discard from hand
							discard.addCard(card); // add to discard pile
							if (card instanceof ErnieAndBert) {
								System.out.println("Computer draws 1 card");
								computer.setDrawOne(true);
							} else if (card instanceof Oscar) {
								System.out.println("Computer draws 2 cards");
								computer.setDrawTwo(true);
							}
						}
					}

				}
				if (computer.getHand().length == 0) {
					computer.setWon(true);
					gameOver = true;
				}
				switchTurn(human, computer);
				System.out.println("(" + deck.getDeck().length + ") card remaining");
			}
		}

		if (human.getWon()) {
			System.out.println("YOU WON!!!");
		} else {
			System.out.println("COMPUTER WON!!!");
		}

	}

	public static void checkDeck(CardDeck deck, DiscardPile discard, int modifier) {
		if (deck.getDeck().length - modifier < 0) {
			System.out.println("________________________________________________________________________________");

			Card tempCard = discard.getDeck()[discard.getDeck().length - 1];
			for (int i = 0; i < discard.getDeck().length; i++) {
				deck.addCard(discard.getDeck()[i]);
			}

			for (int i = 0; i < discard.getDeck().length; i++) {
				discard.getDeck()[i] = null;
			}
			discard.resize();
			discard.addCard(tempCard);

			deck.shuffle();

		}
	}

	public static Player prep(CardDeck deck, Player one, Player two) {
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

		if (userHigh.getNumber() == compHigh.getNumber()) {
			System.out.println("Players both drew same value card");
			return null;
		} else if (userHigh.getNumber() > compHigh.getNumber()) {
			return one;
		} else {
			return two;
		}
	}

	public static void printDeck(Object deck) {
		System.out.println("----------------------------------------------");
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
		System.out.println("----------------------------------------------");

	}

	public static void switchTurn(Player one, Player two) {
		if (one.getTurn()) {
			one.setTurn(false);
			two.setTurn(true);
		} else {
			one.setTurn(true);
			two.setTurn(false);
		}

	}

}
