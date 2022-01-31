package solution;

//this class represents a 5-scale likert question
//the scales are strongly agree, agree, neither agree nor disagree, disagree and strongly disagree
public class LikertQuestion extends AbstractQuestion {

  //a valid question must have text
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text);
    if ((text.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    options = new String[]{"strongly agree", "agree", "neither agree nor disagree", "disagree", "strongly disagree"};
    type = "Likert";
  }

  protected Question whichQuestion(String questionText) {
    return new LikertQuestion(questionText);
  }
}
