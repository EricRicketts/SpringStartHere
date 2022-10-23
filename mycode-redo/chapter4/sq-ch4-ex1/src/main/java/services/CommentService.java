package services;

import model.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

public class CommentService {

  private final CommentRepository commentRepository;
  private final CommentNotificationProxy commentNotificationProxy;

  public CommentService(
      CommentRepository commentRepository,
      CommentNotificationProxy commentNotificationProxy) {
      this.commentRepository = commentRepository;
      this.commentNotificationProxy = commentNotificationProxy;
  }

  public String publishComment(Comment comment) {
    var stored = commentRepository.storeComment(comment);
    var sent = commentNotificationProxy.sendComment(comment);
    return stored + " " + sent;
  }
}
