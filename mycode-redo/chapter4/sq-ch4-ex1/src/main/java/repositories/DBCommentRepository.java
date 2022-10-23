package repositories;

import model.Comment;

public class DBCommentRepository implements CommentRepository {

  @Override
  public String storeComment(Comment comment) {
    return "Stored comment with author: " + comment.getAuthor() +
        " and text: " + comment.getText();
  }

}
