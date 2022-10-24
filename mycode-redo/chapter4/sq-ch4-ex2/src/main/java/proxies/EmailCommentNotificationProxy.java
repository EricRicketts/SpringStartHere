package proxies;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

  @Override
  public String sendComment(Comment comment) {
    return "Email comment from Author: " + comment.getAuthor() +
    " with text: " + comment.getText();
  }
}
