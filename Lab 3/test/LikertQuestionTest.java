import solution.LikertQuestion;
import solution.Question;


/**
 * Tests for {@link LikertQuestion}.
 */
public class LikertQuestionTest extends AbstractQuestionTest {

  public LikertQuestionTest() {
    super();
    answers = new String[]{"strongly agree", "agree",
            "neither agree nor disagree", "disagree", "strongly disagree"};
    incorrectAnswers = new String[]{"weakly disagree", ""};
    type = "Likert";
  }

  protected Question whichQuestion(String question) {
    return new LikertQuestion(question);
  }
}