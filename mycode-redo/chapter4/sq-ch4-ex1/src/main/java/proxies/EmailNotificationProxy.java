package proxies;

import model.Comment;

public class EmailNotificationProxy implements CommentNotificationProxy {

  @Override
  public String sendComment(Comment comment) {
    return "Sent comment with author: " + comment.getAuthor() +
        " and text: " + comment.getText();
  }
}
