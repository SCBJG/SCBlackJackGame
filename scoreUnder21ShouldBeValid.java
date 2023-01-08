import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class scoreUnder21ShouldBeValid {

	@Test
	public void test() {
		//Given
		PlayBlackJack PBJTest = new PlayBlackJack();
		ArrayList<Card> testPlayerHand = new ArrayList<Card>();
		Card[] deckOfCards = new Card[52];
		Card testCard1 = new Card("Hearts", 4);
		Card testCard2 = new Card("Clubs",1);
		
		testPlayerHand.add(testCard1);
		testPlayerHand.add(testCard2);
		
		int pointsValueOfHand =	PBJTest.evaulateHand(testPlayerHand);
		String validHand = PBJTest.isHandValid(pointsValueOfHand);
		assertEquals("Valid",validHand);
	}

}
