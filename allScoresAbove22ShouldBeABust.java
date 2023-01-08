import static org.junit.Assert.*;

import org.junit.Test;

public class allScoresAbove22ShouldBeABust {

	@Test
	public void test() {
		PlayBlackJack PBJTest = new PlayBlackJack();
		boolean handHasBust = true;
		for(int i = 22; i < Integer.MAX_VALUE; i++) {
			if(PBJTest.isHandValid(i).equals("Bust") == false) {
				handHasBust = false;
			}
		}
		assertEquals(true,handHasBust);

	}


}
