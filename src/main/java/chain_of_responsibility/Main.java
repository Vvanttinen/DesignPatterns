package chain_of_responsibility;

import chain_of_responsibility.handlers.*;
import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public class Main {
  public static void main(String[] args) {
    Handler handlerChain = new CompensationClaimHandler();
    handlerChain
            .setNext(new ContactRequestHandler())
            .setNext(new DevelopmentSuggestionHandler())
            .setNext(new GeneralFeedbackHandler());

    Message msg1 = new Message(MessageType.COMPENSATION_CLAIM, "My flight was delayed, requesting compensation.", "alice@example.com");
    Message msg2 = new Message(MessageType.CONTACT_REQUEST, "I need to update my billing info.", "bob@example.com");
    Message msg3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Please add dark mode to the app.", "charlie@example.com");
    Message msg4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service overall!", "diana@example.com");

    handlerChain.handle(msg1);
    handlerChain.handle(msg2);
    handlerChain.handle(msg3);
    handlerChain.handle(msg4);
  }
}
