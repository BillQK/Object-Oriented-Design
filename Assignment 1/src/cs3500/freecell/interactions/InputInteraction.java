package cs3500.freecell.interactions;

public class InputInteraction implements Interaction {
  String input;
  InputInteraction(String input) {
    this.input = input;
  }

  @Override
  public void apply(StringBuilder in, StringBuilder out) {
  in.append(input);
  }
}
