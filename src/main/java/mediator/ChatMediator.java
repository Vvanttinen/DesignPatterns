package mediator;

public interface ChatMediator {
  void registerClient(ChatClientController client);
  void sendMessage(String from, String to, String message);
}
