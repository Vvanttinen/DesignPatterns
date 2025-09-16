package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
  private Model model;
  private Gui gui;
  private List<IMemento> history; // Memento history
  private List<IMemento> redoHistory;

  public Controller(Gui gui) {
    this.model = new Model();
    this.gui = gui;
    this.history = new ArrayList<>();
    this.redoHistory = new ArrayList<>();
  }

  public void setOption(int optionNumber, int choice) {
    saveToHistory();
    model.setOption(optionNumber, choice);
  }

  public int getOption(int optionNumber) {
    return model.getOption(optionNumber);
  }

  public void setIsSelected(boolean isSelected) {
    saveToHistory();
    model.setIsSelected(isSelected);
  }

  public boolean getIsSelected() {
    return model.getIsSelected();
  }

  public void undo() {
    if (!history.isEmpty()) {
      System.out.println("Memento found in history");
      IMemento previousState = history.remove(history.size() - 1);
      redoHistory.add(model.createMemento());
      model.restoreState(previousState);
      gui.updateGui();
    }
  }

  public void redo() {
    if (!redoHistory.isEmpty()) {
      IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
      history.add(model.createMemento());
      model.restoreState(nextState);
      gui.updateGui();
    }
  }

  private void saveToHistory() {
    IMemento currentState = model.createMemento();
    history.add(currentState);
    redoHistory.clear();
  }
}
