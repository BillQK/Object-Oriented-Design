package cs3500.freecell.interactions;

public class PrintInteraction implements Interaction{
  String[] lines;
  PrintInteraction(String... lines) {
    this.lines = lines;
  }

  @Override
  public void apply(StringBuilder in, StringBuilder out) {
    for (String line: lines) {
      out.append(line).append("\n");
    }
  }
}
