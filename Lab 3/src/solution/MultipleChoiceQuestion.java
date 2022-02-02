package solution;


/**
 * This class represent a Multiple Choice question, there are 4 choices which
 * is ranging from 1 to 4.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {
  /**
   * A constructor of a Multiplechoicequestion class.
   *
   * @param questionText A String which represent the question.
   * @throws IllegalArgumentException if the parameters is an empty String, then it
   *                                  is invalid.
   */
  public MultipleChoiceQuestion(String questionText) throws IllegalArgumentException {
    super(questionText);
    options = new String[]{"1", "2", "3", "4"};
    type = "MultipleChoice";
  }


}