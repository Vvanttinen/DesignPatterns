package chain_of_responsibility.handlers;

import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public abstract class Handler {
  private Handler nextHandler;

  public Handler setNext(Handler handler) {
    this.nextHandler = handler;
    return handler;
  }

  public void handle(Message message) {
    if (canHandle(message.getType())) {
      process(message);
    } else if (nextHandler != null) {
      nextHandler.handle(message);
    } else {
      System.out.println("No handler available for message: " + message.getContent());
    }
  }

  protected abstract boolean canHandle(MessageType type);
  protected abstract void process(Message message);
}
