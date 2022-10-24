package org.example;

import model.Comment;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class App {
  public static void main(String[] args) {
    EmailCommentNotificationProxy emailCommentNotificationProxy = new EmailCommentNotificationProxy();
    DBCommentRepository dbCommentRepository = new DBCommentRepository();
    CommentService commentService = new CommentService(emailCommentNotificationProxy, dbCommentRepository);

    Comment comment = new Comment();
    comment.setAuthor("Elmer Fudd");
    comment.setText("Be very quiet!!");

    System.out.println(commentService.publishComment(comment));
  }
}
