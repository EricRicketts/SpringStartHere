package repositories;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {

  @Override
  public String storeComment(Comment comment) {
    return "Inserted comment with Author: " + comment.getAuthor() +
        " and text: " + comment.getText();
  }
}
