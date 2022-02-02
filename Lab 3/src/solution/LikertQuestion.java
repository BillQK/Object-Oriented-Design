package solution;

/**
 * This class represent a 5-scele likert question, the scales are strongly agree, agree,
 * neither agree nor disagree, disagree, and strongly disagree.
 */
public class LikertQuestion extends AbstractQuestion {
  /**
   * A constructor for LikertQuestion that has a text.
   *
   * @param text A String which represent the question text
   * @throws IllegalArgumentException if the parameter is an empty String, then
   *                                  throws an illegal argument exception.
   */
  //a valid question must have text
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text);
    options = new String[]{"strongly agree", "agree","neither agree nor disagree", "disagree",
                           "strongly disagree"};
    type = "Likert";
  }
}
