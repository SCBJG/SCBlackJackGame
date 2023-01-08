import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayBlackJack {
	private int placeInDeck;
	private Card[] deckOfCards;
	private boolean roundOver;
	public static void main(String[] args) {

		//Initialise variables.
		PlayBlackJack PBJ = new PlayBlackJack();

		//Flag variable for user to quit out of the program
		boolean gameOver = false;
		Scanner input = new Scanner(System.in); 

		//Initialise deck. Chose array as it will always be 52 long so can use an static data structure. 
		Card[] deckOfCards = new Card[52];
		deckOfCards = PBJ.createDeckOfCards(deckOfCards);


		//Uncomment for printing out the unshuffled deck for debug purposes.
		//System.out.println("----------------------------------------Unshuffled----------------------------------------");
		//PBJ.printCurrentDeck(deckOfCards);

		while (gameOver == false){
			//Look at the start of the deck.
			PBJ.setPlaceInDeckTo0();
			//Shuffle the deck by randomly changing the location of the cards in the array.
			PBJ.shuffleDeck(deckOfCards);
			
			//Uncomment for debug to see shuffled deck of cards.
			//System.out.println("-----------------------------------------Shuffle------------------------------------------------");
			//PBJ.printCurrentDeck(deckOfCards);

			System.out.println("----------------------------------------In game----------------------------------------");
			//ArrayList to hold the player's cards.
			ArrayList<Card> playerHand = new ArrayList<Card>();
			playerHand = PBJ.dealCards(deckOfCards, playerHand, "Start");

			System.out.println("----------------------------------------First Two Deals----------------------------------------");
			PBJ.printCurrentHand(playerHand);
			System.out.println("Hand Total: "+ PBJ.evaulateHand(playerHand));
			//Load into the 'round' which is where the player can hit or stand depending on their input.
			PBJ.setRoundOver(false);
			while (PBJ.isRoundOver() == false) {
				//Check if the hand is valid i.e. ends the game if the score is greater than 21 (bust and the player has lost) or equals 21 (blackjack and the player has won)
				int currentPointsTotalOfHand = PBJ.evaulateHand(playerHand);
				String currentStatus = PBJ.isHandValid(currentPointsTotalOfHand);
				//If the hand is not valid, the round is over and the user is told of their win/loss and asked if they want to play another round. If it is valid, they can either hit (get another card) or stand (leave and end round). 
				if(PBJ.isHandValid(currentPointsTotalOfHand).equals("Bust")) {
					System.out.println("Bust! You Lose.");
					PBJ.setRoundOver(true);
				}else if(currentStatus.equals("BlackJack")){
					System.out.println("BlackJack! You win.");
					PBJ.setRoundOver(true);
				}else {
					//Find user decision if they want to hit or stand if their hand is still valid.
					System.out.println("Hit or Stand? Please enter either H or 1 for another card. Please enter either S or 0 to end the game and check your score.");
					String userDecision = input.nextLine();
					//Validate the user input i.e. is it one of H,1,S or 0. 
					userDecision = PBJ.validatePlayerActionInput(userDecision);
					//Either draw another card or end the round.
					playerHand = PBJ.playRoundOfBlackJack(userDecision, playerHand, deckOfCards);
				}
			}
			//Check if player would like to play another round. 
			System.out.println("Would you like to play again? Please type Yes or No");
			String playAnotherRound = input.nextLine();
			//Validate input. Either Yes or No.
			playAnotherRound = PBJ.validatePlayAnotherRound(playAnotherRound);
			//If no, end the game and also the program.
			if(playAnotherRound.equals("Quit")) {
				PBJ.setRoundOver(true);
				gameOver = true;
			}


		}

	}


	public String validatePlayerActionInput(String userDecision) {

		boolean invalidInput = true;
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		while(invalidInput == true) {
			if(userDecision.equals("H") || userDecision.equals("1")) {
				userDecision = "Hit";
				invalidInput = false;
			}else if(userDecision.equals("S") || userDecision.equals("0")) {
				userDecision = "Stand";
				invalidInput = false;
			}else {
				System.out.println("Invalid input. Please enter a valid input. H or 1 for Hit. S or 0 for Stand.");
				invalidInput = true;
				userDecision = input.nextLine();
			}
		}
		return userDecision;
	}

	public String validatePlayAnotherRound(String userDecisionAnotherRound) {

		boolean invalidInput = true;
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		while(invalidInput == true) {
			if(userDecisionAnotherRound.equals("Yes")) {
				userDecisionAnotherRound = "New";
				invalidInput = false;
			}
			else if(userDecisionAnotherRound.equals("No")) {
				userDecisionAnotherRound = "Quit";
				invalidInput = false;

			}else {
				System.out.println("Invalid input. Please enter a valid input. Yes or No.");
				invalidInput = true;
				userDecisionAnotherRound = input.nextLine();
			}
		}
		return userDecisionAnotherRound;
	}

	public Card[] createDeckOfCards (Card[] deckOfCards) {
		//Creates a ArrayList for the suits then loops through the arraylist. The values are from 1-13. 1 being an Ace. 2-10 being the same number in card form. 11-13 being Jack,Queen,King.
		ArrayList<String> suits = new ArrayList<String>();
		suits.add("Clubs");
		suits.add("Diamonds");
		suits.add("Hearts");
		suits.add("Spades");
		int counter = 0;
		for (int i = 0; i < suits.size(); i++ ) {
			for (int j = 1; j <= 13; j ++) {
				Card currentCard = new Card(suits.get(i), j);
				deckOfCards[counter] = currentCard;
				counter++;
			}
		}

		return deckOfCards;

	}

	public void printCard(Card cardToBePrinted) {
		String currentValueOfCard = "";
		switch (cardToBePrinted.getValue()) {
		case 1: 
			currentValueOfCard ="Ace";
			break;

		case 2: 
			currentValueOfCard ="Two";
			break;

		case 3: 
			currentValueOfCard ="Three";
			break;

		case 4: 
			currentValueOfCard ="Four";
			break;

		case 5: 
			currentValueOfCard ="Five";
			break;

		case 6: 
			currentValueOfCard ="Six";
			break;

		case 7: 
			currentValueOfCard ="Seven";
			break;

		case 8: 
			currentValueOfCard ="Eight";
			break;

		case 9: 
			currentValueOfCard ="Nine";
			break;

		case 10: 
			currentValueOfCard ="Ten";
			break;

		case 11: 
			currentValueOfCard ="Jack";
			break;

		case 12: 
			currentValueOfCard ="Queen";
			break;

		case 13: 
			currentValueOfCard ="King";
			break;
		default: 
			currentValueOfCard ="Invalid card";
			break;
		}
		//Uncomment for a simpler card to print Three Diamonds instead of Three of Diamonds. 
		//Test card
		//System.out.println(currentValueOfCard + " " + cardToBePrinted.getSuit());
		//Proper card
		System.out.println(currentValueOfCard + " Of " + cardToBePrinted.getSuit());

	}




	public Card[] shuffleDeck(Card[] unshuffledDeck) {
		//Takes in the full unshuffled deck and uses a predefined random function to randomise the order of the deck so the player does not always know what card they will get next. 
		Card[] shuffledDeck = unshuffledDeck;
		List<Card> deckListToShuffle = Arrays.asList(shuffledDeck);
		//This traverses the list backwards and swaps an element randomly selected from the rest of the list into its current index. 
		Collections.shuffle(deckListToShuffle);
		shuffledDeck = deckListToShuffle.toArray(new Card[shuffledDeck.length]);
		return shuffledDeck;
	}

	public int evaulateHand(ArrayList<Card> playerHand) {
		//Decides how many points the current hand is worth in blackjack rules.
		//Points are worked out in blackJackValueOfCard(Card). 
		//As aces can be either 11 or 1, every ace is treated as an 11 unless an 11 would make the player go bust. 
		//If an 11 would make the player go bust, the ace is treated as a 1.
		//To allow this, when iterating through the hand to determine score, the number of aces in the hand is counted.
		//If the player would bust, the hand is checked for aces that can be turned into 1's.
		//If an ace is found, then it is converted by subtracting 10 from the overall score and is then treated as a 1. 
		
		int pointsTotalOfHand = 0;
		int aceCounter = 0;
		for (int i = 0; i < playerHand.size(); i++) {
			if(playerHand.get(i).getValue() == 1) {
				aceCounter++;
				pointsTotalOfHand = pointsTotalOfHand + this.blackJackValueOfCard(playerHand.get(i));
			}else {
				pointsTotalOfHand = pointsTotalOfHand + this.blackJackValueOfCard(playerHand.get(i));
			}

		}

		while(pointsTotalOfHand > 21 && aceCounter > 0) {
			pointsTotalOfHand = pointsTotalOfHand - 10;
			aceCounter--;
		}
		return pointsTotalOfHand;
	}

	
	public ArrayList<Card> playRoundOfBlackJack(String userDecision, ArrayList<Card> playerHand, Card[] currentDeck) {
		//If the user has decided to stand, then the game is over and their score is printed.
		if (userDecision.equals("Stand")) {
			System.out.println("Final Score: " + this.evaulateHand(playerHand));
			this.setRoundOver(true);
		}else {
			//If the user has decided to hit, they are dealt one extra card.
			this.dealCards(currentDeck, playerHand, "Hit");
			this.printCurrentHand(playerHand);
			System.out.println("Hand Total: "+ this.evaulateHand(playerHand));
		}

		return playerHand;
	}

	public int blackJackValueOfCard(Card cardToBeEvaluated) {
		//Cards 2-10 are worth the points they are assigned e.g. The 4 of Hearts is worth 4 points.
		//Jacks, Queens, and Kings (11,12,13) are treated as 10 points in BlackJack.
		//An Ace is treated as an 11 unless the hand would bust (see evaluateHand(ArrayList<Card>) for the logic and explanation).
		int pointsValueOfCard = 0;
		if(cardToBeEvaluated.getValue() == 1) {
			pointsValueOfCard = 11;
		}else if(cardToBeEvaluated.getValue() > 10) {
			pointsValueOfCard = 10;
		}
		else {
			pointsValueOfCard = cardToBeEvaluated.getValue();
		}
		return pointsValueOfCard;
	}

	public String isHandValid(int pointsValueOfHand) {
		//If the hand goes over 21, it has bust and the player has lost.
		//If the hand is exactly 21, the player has got BlackJack and has won the game.
		//If the hand is lower than 21, the hand is valid and the user is prompted to either stand or hit.
		String validHand = "";

		if(pointsValueOfHand < 21) {
			validHand = "Valid";
		}else if(pointsValueOfHand > 21) {
			validHand = "Bust";
		}else {
			validHand = "BlackJack";
		}

		return validHand;

	}
	public ArrayList<Card> dealCards(Card[] currentDeck,ArrayList<Card> currentPlayerHand, String instruction) {
		//Place in deck keeps track of what cards have already been dealt. This acts as a pointer in a stack and cards are 'popped' off the top.
		//The card is not actually removed but is copied across.
		//If the game is starting the player needs two cards dealt to them, otherwise, they can only ever hit which means only 1 card needs to be popped.
		if(instruction.equals("Start")) {
			int dealStarterHand = 0;
			for(dealStarterHand = 0; dealStarterHand < 2; dealStarterHand++ ) {
				currentPlayerHand.add(currentDeck[this.getPlaceInDeck()]);
				this.incrementPlaceInDeck();
			}
		}else {
			currentPlayerHand.add(currentDeck[this.getPlaceInDeck()]);
			this.incrementPlaceInDeck();
		}

		return currentPlayerHand;

	}
	
	//Printing methods.
	
	public void printCurrentDeck(Card[] deckToPrint) {
		for(int i = 0; i < deckToPrint.length; i++) {
			this.printCard(deckToPrint[i]);
		}
	}

	public void printCurrentHand (ArrayList<Card> handToPrint) {
		for (int i = 0; i < handToPrint.size(); i++) {
			this.printCard(handToPrint.get(i));
		}
	}

//Getters and setters.

	public int getPlaceInDeck() {
		return placeInDeck;
	}


	public void setPlaceInDeck(int updatedPlaceInDeck) {
		this.placeInDeck = updatedPlaceInDeck; 
	}
	public void incrementPlaceInDeck() {
		this.placeInDeck++;
	}

	public void setPlaceInDeckTo0() {
		this.placeInDeck = 0;
	}


	public boolean isRoundOver() {
		return roundOver;
	}


	public void setRoundOver(boolean roundOver) {
		this.roundOver = roundOver;
	}
}
