import org.junit.Test;

import solution.Question;
import solution.YesNoQuestion;

/**
 * Tests for {@link YesNoQuestion}.
 */
public class YesNoQuestionTest extends AbstractQuestionTest {

  /**
   * A constructor for YesNoQuestionTest.
   */
  public YesNoQuestionTest() {
    super();
    answers = new String[]{"yes", "Yes", "YEs", "YeS", "YES", "yEs",
                           "yES", "yeS", "no", "No", "nO", "NO"};
    incorrectAnswers = new String[]{"yess", ""};
    type = "YesNo";
  }


  @Override
  protected Question whichQuestion(String question) {
    return new YesNoQuestion(question);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoQuestionMark() {
    new YesNoQuestion("Is this fun");
  }

}