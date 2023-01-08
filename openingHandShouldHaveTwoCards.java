import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class openingHandShouldHaveTwoCards {

	@Test
	public void test() {
		//Given
		PlayBlackJack PBJTest = new PlayBlackJack();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		Card[] deckOfCards = new Card[52];
		deckOfCards = PBJTest.createDeckOfCards(deckOfCards);
		playerHand = PBJTest.dealCards(deckOfCards, playerHand, "Start");
		
		int numberOfCardsInPlayerHand = playerHand.size();
		assertEquals(2,numberOfCardsInPlayerHand);

	}

}
