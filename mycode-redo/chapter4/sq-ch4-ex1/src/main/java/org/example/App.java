package org.example;

import model.Comment;
import proxies.EmailNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class App {
  public static void main(String[] args) {
    var commentRepository = new DBCommentRepository();
    var commentNotificationProxy = new EmailNotificationProxy();

    var commentService = new CommentService(
        commentRepository, commentNotificationProxy
    );

    var comment = new Comment();
    comment.setAuthor("Elmer Fudd");
    comment.setText("I am gong to get that wrassically wrabbit!!");

    System.out.println(commentService.publishComment(comment));
  }
}
