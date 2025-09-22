package proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
  private final Map<Integer, Document> documents = new HashMap<>();

  public void addDocument(int id, String content) {
    RealDocument doc = new RealDocument(id, content);
    documents.put(id, doc);
  }

  public void addProtectedDocument(int id, String content, String[] allowedUsers) {
    RealDocument realDoc = new RealDocument(id, content);
    DocumentProxy proxyDoc = new DocumentProxy(realDoc);
    documents.put(id, proxyDoc);
    for (String user : allowedUsers) {
      AccessControlService.getInstance().grantAccess(user, id);
    }
  }

  public Document getDocument(int id) {
    return documents.get(id);
  }
}
