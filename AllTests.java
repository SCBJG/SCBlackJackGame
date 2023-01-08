import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ kingAndAceShouldEqual21.class ,
	kingQueenAndAceShouldBe21.class,
	nineAceAndAceShouldBe21.class,
	openingHandShouldHaveTwoCards.class,
	allScoresUnder21ShouldBeValid.class,
	allScoresAbove22ShouldBeABust.class,
	WhenHitChosenShouldReceiveCard.class,
	WhenStandChosenShouldNotReceiveCard.class,
	scoreUnder21ShouldBeValid.class})
public class AllTests {

}
