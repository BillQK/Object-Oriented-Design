import org.junit.Test;

import solution.LikertQuestion;
import solution.Question;

import static org.junit.Assert.assertEquals;


/**
 * Tests for {@link LikertQuestion}.
 */
public class LikertQuestionTest extends AbstractQuestionTest {

  /**
   * A constructor for LikerQuestionTest.
   */
  public LikertQuestionTest() {
    super();
    answers = new String[]{"strongly agree", "agree",
                           "neither agree nor disagree", "disagree",
                           "strongly disagree"};
    incorrectAnswers = new String[]{"weakly disagree", ""};
    type = "Likert";
  }

  protected Question whichQuestion(String question) {
    return new LikertQuestion(question);
  }

  @Test
  public void testCreateLikertQuestionWithNoQuestionMark() {
    Question a = new LikertQuestion("Choose what you like");
    assertEquals("Choose what you like", a.getQuestionText());
  }
}