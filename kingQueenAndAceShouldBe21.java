import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class kingQueenAndAceShouldBe21 {

	@Test
	public void test() {
		//Given
		PlayBlackJack PBJTest = new PlayBlackJack();
		
		//When
		ArrayList<Card> testPlayerHand = new ArrayList<Card>();
		Card testCard1 = new Card("Hearts", 13);
		Card testCard2 = new Card("Clubs",12);
		Card testCard3 = new Card ("Diamond",1);

		testPlayerHand.add(testCard1);
		testPlayerHand.add(testCard2);
		testPlayerHand.add(testCard3);
		
		//Expected 21, Actual
		assertEquals(21,PBJTest.evaulateHand(testPlayerHand));
	}

}
