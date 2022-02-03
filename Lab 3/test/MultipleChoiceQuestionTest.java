import org.junit.Test;

import solution.MultipleChoiceQuestion;
import solution.Question;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link MultipleChoiceQuestion}.
 */
public class MultipleChoiceQuestionTest extends AbstractQuestionTest {
  /**
   * A constructor for MultipleChoiceQuestion Test.
   */
  public MultipleChoiceQuestionTest() {
    super();
    answers = new String[]{"1", "2", "3", "4"};
    incorrectAnswers = new String[]{"123", "hi", "?", "fd", ""};
    type = "MultipleChoice";

  }

  @Override
  protected Question whichQuestion(String question) {
    return new MultipleChoiceQuestion(question);
  }

  @Test
  public void testCreateMultipleChoiceQuestionWithNoQuestionMark() {
    Question a = new MultipleChoiceQuestion("Choose what is correct");
    assertEquals("Choose what is correct", a.getQuestionText());
  }
}