package services;

import model.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

public class CommentService {
  private final CommentNotificationProxy commentNotificationProxy;
  private final CommentRepository commentRepository;

  public CommentService(
    CommentNotificationProxy commentNotificationProxy,
    CommentRepository commentRepository
  ) {
    this.commentNotificationProxy = commentNotificationProxy;
    this.commentRepository = commentRepository;
  }

  public CommentNotificationProxy getCommentNotificationProxy() {
    return commentNotificationProxy;
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }

  public String publishComment(Comment comment) {
    return this.getCommentNotificationProxy().sendComment(comment) + " " +
        this.getCommentRepository().storeComment(comment);
  }
}
