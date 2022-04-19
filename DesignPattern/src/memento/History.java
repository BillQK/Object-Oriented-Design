package memento;

import java.util.ArrayList;
import java.util.List;

public class History {
  private List<EditorState> list = new ArrayList<>();

  public void push(EditorState state) {
    list.add(state);
  }

  public EditorState pop() {
    var lastIndex = list.size() - 1;
    var lastState = list.get(lastIndex);
    list.remove(lastState);

    return lastState;
  }

}
