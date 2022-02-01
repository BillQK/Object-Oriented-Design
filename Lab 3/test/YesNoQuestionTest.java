import org.junit.Test;

import java.util.Random;

import solution.Question;
import solution.YesNoQuestion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class YesNoQuestionTest extends AbstractQuestionTest {

  public YesNoQuestionTest() {
    super();
    answers = new String[]{"yes", "Yes",
            "YEs", "YeS", "YES", "yEs",
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