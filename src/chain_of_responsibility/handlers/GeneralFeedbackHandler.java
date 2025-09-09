package chain_of_responsibility.handlers;

import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public class GeneralFeedbackHandler extends Handler {
  @Override
  protected boolean canHandle(MessageType type) {
    return type == MessageType.GENERAL_FEEDBACK;
  }

  @Override
  protected void process(Message message) {
    System.out.println("Analyzing general feedback from " + message.getEmail());
    System.out.println("Feedback: " + message.getContent());
    System.out.println("Response: Thank you for your feedback!");
  }
}