package mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application {
  public void start(Stage stage) {
    BasicChatMediator mediator = new BasicChatMediator();

    createClientWindow("Alice", mediator);
    createClientWindow("Bob", mediator);
    createClientWindow("Charlie", mediator);
  }

  private void createClientWindow(String username, ChatMediator mediator) {
    ChatClientController client = new ChatClientController(username, mediator);

    Stage stage = new Stage();
    stage.setTitle("Chat - " + username);
    stage.setScene(new Scene(client.getUI(), 300, 400));
    stage.show();
  }
}
