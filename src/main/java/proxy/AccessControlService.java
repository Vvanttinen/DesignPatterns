package proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
  private static AccessControlService instance;
  private final Map<Integer, Set<String>> permissions;

  private AccessControlService() {
    permissions = new HashMap<>();
  }
  public static AccessControlService getInstance() {
    if (instance == null) {
      instance = new AccessControlService();
    }
    return instance;
  }

  public void grantAccess(String username, int docId) {
    permissions.putIfAbsent(docId, new java.util.HashSet<>());
    permissions.get(docId).add(username);
  }

  public boolean isAllowed(String username, int docId) {
    return permissions.containsKey(docId) && permissions.get(docId).contains(username);
  }
}
