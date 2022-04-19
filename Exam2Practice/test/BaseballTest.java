import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import cs3500.baseball.BasicPlayer;
import cs3500.baseball.BattingLineup;
import cs3500.baseball.Lineup;
import cs3500.baseball.Player;
import cs3500.baseball.Position;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BaseballTest {
  private Player mookie, jbj, ab, jd, ed, sl, mm, xb, rd;
  private Lineup rs;

  @Before
  public void setup() {
    mookie = new BasicPlayer("Mookie", 50, Position.RIGHT_FIELD);
    jbj = new BasicPlayer("JBJ", 19, Position.CENTER_FIELD);
    ab = new BasicPlayer("Andrew", 16, Position.LEFT_FIELD);
    jd = new BasicPlayer("JD", 28, Position.DESIGNATED_HITTER);
    ed = new BasicPlayer("Eduardo", 36, Position.SECOND_BASE);
    sl = new BasicPlayer("Sandy", 3, Position.CATCHER);
    mm = new BasicPlayer("Mitch", 18, Position.FIRST_BASE);
    xb = new BasicPlayer("Xander", 2, Position.SHORTSTOP);
    rd = new BasicPlayer("Rafael", 11, Position.THIRD_BASE);
    rs = new BattingLineup();
  }

  @Test
  public void battingTest() {
    rs.addPlayer(mookie, 1);
    rs.addPlayer(jbj, 2);
    rs.addPlayer(ab, 3);
    assertFalse(rs.isComplete());
    assertEquals(Arrays.asList(null,mookie,jbj,ab,null,null,null,null,null,null), rs.getLineup());
  }

  @Test
  public void battingGapTest() {
    rs.addPlayer(mookie, 1);
    rs.addPlayer(jbj, 2);
    rs.addPlayer(ab, 8);
    assertFalse(rs.isComplete());
    assertEquals(Arrays.asList(null,mookie,jbj,null,null,null,null,null,ab,null), rs.getLineup());
  }

  @Test
  public void battingTestFull() {
    rs.addPlayer(xb, 8);
    rs.addPlayer(sl, 6);
    rs.addPlayer(mookie, 1);
    rs.addPlayer(jbj, 2);
    rs.addPlayer(ab, 3);
    rs.addPlayer(jd, 4);
    rs.addPlayer(ed, 5);
    rs.addPlayer(mm, 7);
    rs.addPlayer(rd, 9);
    assertTrue(rs.isComplete());
    assertEquals(3, rs.getOrder(ab));
    assertEquals(2, rs.getOrder(jbj));
    assertEquals(Arrays.asList(null, mookie, jbj, ab, jd, ed, sl, mm, xb, rd), rs.getLineup());
    rs.removePlayer(jbj);
    assertEquals(Arrays.asList(null, mookie, null, ab, jd, ed, sl, mm, xb, rd), rs.getLineup());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testOrderExists() {
    rs.addPlayer(xb, 8);
    rs.addPlayer(sl, 6);
    rs.addPlayer(mookie, 1);
    rs.addPlayer(jbj, 2);
    rs.addPlayer(mm, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPositionExists() {
    // Mitch is a Catcher here
    Player mitch = new BasicPlayer("Mitch", 18, Position.CATCHER);
    rs.addPlayer(xb, 8);
    rs.addPlayer(sl, 6);
    rs.addPlayer(mookie, 1);
    rs.addPlayer(jbj, 2);
    rs.addPlayer(mitch, 4);
  }
}