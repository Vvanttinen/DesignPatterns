package mediator;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ChatClientController {
  private final String username;
  private final ChatMediator mediator;

  private TextArea chatArea;
  private TextField messageField;
  private ComboBox<String> recipientBox = new ComboBox<>();
  private Button sendButton;

  public ChatClientController(String username, ChatMediator mediator) {
    this.username = username;
    this.mediator = mediator;
    this.mediator.registerClient(this);
  }

  public String getUsername() {
    return username;
  }

  public VBox getUI() {
    chatArea = new TextArea();
    chatArea.setEditable(false);

    messageField = new TextField();
    recipientBox.getItems().add("ALL");
    recipientBox.setValue("ALL");

    sendButton = new Button("Send");
    sendButton.setOnAction(e -> {
      String msg = messageField.getText();
      String recipient = recipientBox.getValue();
      if (!msg.isEmpty()) {
        mediator.sendMessage(username, recipient, msg);
        messageField.clear();
      }
    });

    return new VBox(5, chatArea, messageField, recipientBox, sendButton);
  }

  public void addRecipient(String name) {
    if (!recipientBox.getItems().contains(name)) {
      recipientBox.getItems().add(name);
    }
  }

  public void receiveMessage(String from, String message) {
    chatArea.appendText(from + ": " + message + "\n");
  }
}
