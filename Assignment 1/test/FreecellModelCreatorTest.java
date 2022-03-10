import org.junit.Test;

import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.SimpleFreecellModel;
import cs3500.freecell.model.multimove.MultiMoveFreecellModel;

import static org.junit.Assert.assertEquals;

/**
 * A test class for FreeCell model. 
 */
public class FreecellModelCreatorTest {
  @Test
  public void testCreate() {
    assertEquals(FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE).getClass(),
            MultiMoveFreecellModel.class);
    assertEquals(FreecellModelCreator.create(FreecellModelCreator.GameType.SINGLEMOVE).getClass(),
            SimpleFreecellModel.class);
    try {
      FreecellModelCreator.create(null);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Game Type cannot be null");
    }
  }
}