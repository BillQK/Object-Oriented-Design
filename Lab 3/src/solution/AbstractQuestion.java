package solution;


/**
 * Abstract base class for implementations of {@link Question}.
 */
abstract class AbstractQuestion implements Question {
  protected final String questionText;
  protected String enteredAnswer;
  protected String[] options;
  protected String type;

  /**
   * A constructor for AbstractQuestion.
   *
   * @param questionText a String which represent the question
   * @throws IllegalArgumentException if the question is an empty String,
   *                                  then it is illegal and invalid
   */
  public AbstractQuestion(String questionText) throws IllegalArgumentException {
    if (questionText.isEmpty()) {
      throw new IllegalArgumentException("Question Text cannot be empty");
    }
    this.questionText = questionText;
    enteredAnswer = "";
  }


  /**
   * A method that represent the operation of answering the question.
   *
   * @param enteredAnswer the answer entered for this question by a student.
   * @throws IllegalArgumentException if the enteredAnswer is not in one of the
   *                                  options provided, then it is invalid.
   */
  public void answer(String enteredAnswer) throws IllegalArgumentException {
    for (String option : options) {
      if (enteredAnswer.toLowerCase().equals(option)) {
        this.enteredAnswer = enteredAnswer.toLowerCase();
        return;
      }
    }
    throw new IllegalArgumentException("Invalid Answer");
  }

  /**
   * a method that check if the question has been answer or not.
   *
   * @return a boolean value, if the question has been answered, it is true,
   * else it is false.
   */
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

  /**
   * A method that get the entered answer.
   *
   * @return A String that represent what the user's answer for the question.
   * @throws IllegalStateException if the user didn't answer, then calling this
   *                               method will return a IllegalStateException.
   */
  public String getEnteredAnswer() throws IllegalStateException {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.solution.Question not attempted yet");
    } else {
      return enteredAnswer;
    }
  }

  /**
   * a method that gets the Question.
   *
   * @return a String value that represent the question.
   */
  public String getQuestionText() {
    return questionText;
  }

  /**
   * a method that get the type of question.
   *
   * @return a String value that represent the question's type.
   */
  public String getType() {
    return this.type;
  }


}