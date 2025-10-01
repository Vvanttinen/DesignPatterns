package mediator;

import java.util.HashMap;
import java.util.Map;

public class BasicChatMediator implements ChatMediator {
  private final Map<String, ChatClientController> clients = new HashMap<>();

  @Override
  public void registerClient(ChatClientController client) {
    clients.put(client.getUsername(), client);
    for (ChatClientController cli : clients.values()) {
      if (!cli.getUsername().equals(client.getUsername())) {
        cli.addRecipient(client.getUsername());
        client.addRecipient(cli.getUsername());
      }
    }
  }

  @Override
  public void sendMessage(String from, String to, String message) {
    if (to.equalsIgnoreCase("ALL")) {
      for (ChatClientController c : clients.values()) {
        c.receiveMessage(from, message);
      }
    } else {
      ChatClientController recipient = clients.get(to);
      ChatClientController sender = clients.get(from);

      if (recipient != null && sender != null) {
        recipient.receiveMessage("whisper from " + from, message);
        sender.receiveMessage("whisper to " + to, message);
      }
    }
  }
}
