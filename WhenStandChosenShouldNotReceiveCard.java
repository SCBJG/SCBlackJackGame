import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WhenStandChosenShouldNotReceiveCard {

	@Test
	public void test() {
		//		Given I have a valid hand of cards
		//		When I choose to ‘stand’
		//		Then I receive no further cards
		//		And my score is evaluated
		//		Given I have a valid hand of cards
		//		When I choose to ‘hit’
		//		Then I receive another card
		//		And my score is updated
		//Set up deck and hand.
		PlayBlackJack PBJTest = new PlayBlackJack();
		Card[] deckOfCards = new Card[1];
		ArrayList<Card> playerHand = new ArrayList<Card>();
		deckOfCards[0] = new Card("Diamonds",3);
		playerHand.add(new Card("Clubs", 4));
		playerHand.add(new Card("Hearts",5));
		//Check value of hand before to compare later
		int valueOfHandBeforeHit = PBJTest.evaulateHand(playerHand);
		//Given the hand is valid
		boolean handIsValid = false;
		if(PBJTest.isHandValid(valueOfHandBeforeHit).equals("Valid") == true) {
				handIsValid = true;
		}
		//Check size of hand to compare later
		int sizeOfHandBeforeHit = playerHand.size();
		//Simulate a user input of hit which should add a card to the hand
		if(handIsValid == true) {
			PBJTest.playRoundOfBlackJack("Stand", playerHand, deckOfCards);
		}
		//Check that a card has been added to hand 
		int sizeOfHandAfterHit = playerHand.size();
		//Check that the value of the hand has changed with the new card added
		int valueOfHandAfterHit = PBJTest.evaulateHand(playerHand);
		boolean testPassed = false;
		//If everything is correct, testPassed should change to true.
		if(handIsValid == true && (sizeOfHandBeforeHit == sizeOfHandAfterHit) && (valueOfHandBeforeHit == valueOfHandAfterHit)) {
			testPassed = true;
		}
		
		
		assertEquals(true,testPassed);
		}
	}


