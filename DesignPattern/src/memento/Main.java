package memento;

public class Main   {
  public static void main(String[] args) {
    var history = new History();
    var editor = new Editor();

    editor.setContent("a");
    history.push(editor.createState());
    editor.setContent("b");
    history.push(editor.createState());
    editor.setContent("c");
    history.push(editor.createState());

    editor.restoreState(history.pop());
    editor.restoreState(history.pop());

    System.out.println(editor.getContent());
  }
}
