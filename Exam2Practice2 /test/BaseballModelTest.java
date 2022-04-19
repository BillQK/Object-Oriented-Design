import static org.junit.Assert.assertEquals;

import cs3500.baseball.AtPlateResult;
import cs3500.baseball.BasicPlayer;
import cs3500.baseball.Player;
import cs3500.baseball.Position;
import org.junit.Test;

public class BaseballModelTest {
  @Test
  public void testSomething() {
    Player mookie = new BasicPlayer("Mookie", 50, Position.RIGHT_FIELD);
    mookie.addAtPlate(AtPlateResult.WALK);
    mookie.addAtPlate(AtPlateResult.STRIKEOUT);
    mookie.addAtPlate(AtPlateResult.OTHER_OUT);
    mookie.addAtPlate(AtPlateResult.SINGLE, AtPlateResult.RUN);
    mookie.addAtPlate(AtPlateResult.OTHER_OUT);
    assertEquals(0.250, mookie.getBattingAvg(), 0.001);
    assertEquals(0.400, mookie.getOnBaseAvg(), 0.001);
    assertEquals(0.250, mookie.getSluggingAvg(), 0.001);
    mookie.addAtPlate(AtPlateResult.DOUBLE, AtPlateResult.RUN, AtPlateResult.RUN);
    assertEquals(3, mookie.getStat(AtPlateResult.RUN_BATTED_IN));
    mookie.addAtPlate(AtPlateResult.TRIPLE, AtPlateResult.RUN, AtPlateResult.ERROR);
    assertEquals(3, mookie.getStat(AtPlateResult.RUN_BATTED_IN));
    assertEquals(0, mookie.getStat(AtPlateResult.ERROR));
    assertEquals(6, mookie.getAtBats());
    assertEquals((double)(1 + 2 + 3) / 6, mookie.getSluggingAvg(), 0.001);
    mookie.addAtPlate(AtPlateResult.HOME_RUN);
    assertEquals(4, mookie.getStat(AtPlateResult.RUN_BATTED_IN));
  }
}
