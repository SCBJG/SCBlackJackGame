import static org.junit.Assert.*;

import org.junit.Test;

public class allScoresUnder21ShouldBeValid {

	@Test
	public void test() {
		PlayBlackJack PBJTest = new PlayBlackJack();
		boolean handIsValid = true;
		for(int i = 0; i < 21; i++) {
			if(PBJTest.isHandValid(i).equals("Valid") == false) {
				handIsValid = false;
			}
		}
		assertEquals(true,handIsValid);
		
	}

}
