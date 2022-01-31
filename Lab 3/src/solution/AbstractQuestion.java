package solution;

abstract class AbstractQuestion implements Question {
  protected final String questionText;
  protected String enteredAnswer;
  protected String[] options;
  protected String type;

  public AbstractQuestion(String questionText) {
    if (questionText.isEmpty()) {
      throw new IllegalArgumentException("Question Text cannot be empty");
    }
    this.questionText = questionText;
    enteredAnswer = "";
  }

  public void answer(String enteredAnswer) {
    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        this.enteredAnswer = enteredAnswer;
        return;
      }
    }
    throw new IllegalArgumentException("Invalid Answer");
  }

  public boolean hasBeenAnswered() {
    if (enteredAnswer.isEmpty()) {
      return false;
    }
    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        return true;
      }

    }
    return false;
  }

  public String getEnteredAnswer() {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.solution.Question not attempted yet");
    } else {
      return enteredAnswer;
    }
  }

  public String getQuestionText() {
    return questionText;
  }

  public String getType() {
    return this.type;
  }


}