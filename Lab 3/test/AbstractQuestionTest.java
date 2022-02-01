import org.junit.Test;

import java.util.Random;

import solution.Question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

abstract class AbstractQuestionTest {
  protected String longRandom;
  protected String[] answers;
  protected String[] incorrectAnswers;
  protected String type;


  public AbstractQuestionTest() {
    longRandom = "aosdifjaso oifhas;ldihv;al "
            + "skdfha;osidghv;osiadhvbasdjkhvn";
  }

  protected abstract Question whichQuestion(String question);

  @Test
  public void testCreateValidQuestion() {
    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      Question q = whichQuestion(questionText + "?");
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals(type, q.getType());
    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateQuestionWithNoText() {
    whichQuestion("");
  }

  @Test
  public void testAnswerCorrectly() {
    for (String answer : answers) {
      Question q = whichQuestion("Is this a trick question?");
      assertFalse(q.hasBeenAnswered());

      q.answer(answer);
      assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
    }
  }

  @Test
  public void testAnswerInCorrectly() {
    for (String answer : incorrectAnswers) {
      Question q = whichQuestion("Is this a trick question?");
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail("Question accepted an invalid answer");
      } catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }

}

