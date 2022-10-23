package proxies;

import model.Comment;

public interface CommentNotificationProxy {

  public String sendComment(Comment comment);
}
