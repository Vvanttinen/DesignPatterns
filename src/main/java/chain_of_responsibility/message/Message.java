package chain_of_responsibility.message;

public class Message {
  private final MessageType type;
  private final String content;
  private final String email;

  public Message(MessageType type, String content, String email) {
    this.type = type;
    this.content = content;
    this.email = email;
  }

  public MessageType getType() {
    return type;
  }

  public String getContent() {
    return content;
  }

  public String getEmail() {
    return email;
  }
}
