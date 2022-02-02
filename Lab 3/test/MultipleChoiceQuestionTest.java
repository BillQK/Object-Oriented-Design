import solution.MultipleChoiceQuestion;
import solution.Question;

/**
 * Tests for {@link MultipleChoiceQuestion}.
 */
public class MultipleChoiceQuestionTest extends AbstractQuestionTest {
  public MultipleChoiceQuestionTest() {
    super();
    answers = new String[]{
            "1", "2", "3", "4"
    };
    incorrectAnswers = new String[]{
            "123", "hi", "?", "fd", ""
    };
    type = "MultipleChoice";

  }

  @Override
  protected Question whichQuestion(String question) {
    return new MultipleChoiceQuestion(question);
  }
}