package solution;

/**
 * Represent a YesNo Question, the options is Yes and No.
 */
public class YesNoQuestion extends AbstractQuestion {
  /**
   * A Constructor of an YesNo question.
   *
   * @param text the question
   * @throws IllegalArgumentException if the question doesn't end in a question
   *                                  mark, it is illegal
   */
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text);
    if ((text.length() == 0) || (text.charAt(text.length() - 1) != '?')) {
      throw new IllegalArgumentException("Invalid question text");
    }
    options = new String[]{"yes", "no"};
    type = "YesNo";
  }
}
