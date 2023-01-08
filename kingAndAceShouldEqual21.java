import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class kingAndAceShouldEqual21 {

	@Test
	public void test() {
		//Given
		PlayBlackJack PBJTest = new PlayBlackJack();
		
		//When
		ArrayList<Card> testPlayerHand = new ArrayList<Card>();
		Card testCard1 = new Card("Hearts", 13);
		Card testCard2 = new Card("Clubs",1);
		
		testPlayerHand.add(testCard1);
		testPlayerHand.add(testCard2);

		
		
		assertEquals(21,PBJTest.evaulateHand(testPlayerHand));
	}

}
