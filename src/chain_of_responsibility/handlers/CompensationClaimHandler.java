package chain_of_responsibility.handlers;

import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public class CompensationClaimHandler extends Handler {
  @Override
  protected boolean canHandle(MessageType type) {
    return type == MessageType.COMPENSATION_CLAIM;
  }

  @Override
  protected void process(Message message) {
    System.out.println("Processing compensation claim from " + message.getEmail());
    System.out.println("Claim content: " + message.getContent());
    System.out.println("Decision: Approved");
  }
}