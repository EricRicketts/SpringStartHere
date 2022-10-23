package repositories;

import model.Comment;

public interface CommentRepository {

  public String storeComment(Comment comment);
}
