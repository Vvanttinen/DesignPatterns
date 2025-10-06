package proxy;

import java.util.Date;

public interface Document {
  int getId();
  String getContent(User user) throws AccessDeniedException;
  Date getCreationDate();
}
