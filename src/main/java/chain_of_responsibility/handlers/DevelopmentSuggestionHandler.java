package chain_of_responsibility.handlers;

import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public class DevelopmentSuggestionHandler extends Handler {
  @Override
  protected boolean canHandle(MessageType type) {
    return type == MessageType.DEVELOPMENT_SUGGESTION;
  }

  @Override
  protected void process(Message message) {
    System.out.println("Logging development suggestion from " + message.getEmail());
    System.out.println("Suggestion: " + message.getContent());
    System.out.println("Added to backlog");
  }
}