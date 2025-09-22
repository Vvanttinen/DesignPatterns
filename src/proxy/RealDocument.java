package proxy;

import java.util.Date;

public class RealDocument implements Document {
  private final int id;
  private final String content;
  private final Date creationDate;

  public RealDocument(int id, String content) {
    this.id = id;
    this.content = content;
    this.creationDate = new Date();
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getContent(User user) {
    return content;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }
}
