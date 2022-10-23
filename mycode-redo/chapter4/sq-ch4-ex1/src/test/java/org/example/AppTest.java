package org.example;

import model.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import proxies.EmailNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

  @Test
  @DisplayName("publish a comment sans Spring Framework")
  public void testPublishComment() {
    var comment = new Comment();
    comment.setAuthor("Foo");
    comment.setText("Bar");

    String expected = "Stored comment with author: Foo and text: Bar " +
        "Sent comment with author: Foo and text: Bar";

    var commentRepository = new DBCommentRepository();
    var commentNotificationProxy = new EmailNotificationProxy();

    var commentService = new CommentService(
        commentRepository, commentNotificationProxy);

    assertEquals(expected, commentService.publishComment(comment));
  }
}
