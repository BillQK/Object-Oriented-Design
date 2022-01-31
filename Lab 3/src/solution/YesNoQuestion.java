package solution;

//this class represents a yes/no question
public class YesNoQuestion extends AbstractQuestion {

  //a question must be non empty and should end with a question mark
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text);
    if ((text.length()==0) || (text.charAt(text.length()-1)!='?')) {
      throw new IllegalArgumentException("Invalid question text");
    }
    options = new String[]{"Yes", "No"};
    type = "YesNo";
  }
}
