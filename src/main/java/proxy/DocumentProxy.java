package proxy;

import java.util.Date;

public class DocumentProxy implements Document {
  private final RealDocument realDocument;

  public DocumentProxy(RealDocument realDocument) {
    this.realDocument = realDocument;
  }

  @Override
  public int getId() {
    return realDocument.getId();
  }

  @Override
  public String getContent(User user) throws AccessDeniedException {
    // Check access control before returning content
    if (AccessControlService.getInstance().isAllowed(user.getUsername(), realDocument.getId())) {
      return realDocument.getContent(user);
    } else {
      throw new AccessDeniedException("Access denied for user: " + user.getUsername() + " to document ID: " + realDocument.getId());
    }
  }

  @Override
  public Date getCreationDate() {
    return realDocument.getCreationDate();
  }
}
