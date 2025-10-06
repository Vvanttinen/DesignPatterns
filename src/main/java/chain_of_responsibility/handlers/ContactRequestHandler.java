package chain_of_responsibility.handlers;

import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public class ContactRequestHandler extends Handler {
  @Override
  protected boolean canHandle(MessageType type) {
    return type == MessageType.CONTACT_REQUEST;
  }

  @Override
  protected void process(Message message) {
    System.out.println("Forwarding contact request from " + message.getEmail());
    System.out.println("Message: " + message.getContent());
    System.out.println("Forwarded to: Customer Support");
  }
}