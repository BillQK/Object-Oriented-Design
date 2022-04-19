package state.abuse;

public class Stopwatch {
  private State currentState = new StoppedState(this);
  public void click() {
    currentState.click();
  }

  public void setCurrentState(State currentState) {
    this.currentState = currentState;
  }
}
