package org.example;


import model.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

  @Test
  @DisplayName("publish a comment")
  public void testPublishAComment() {
    Comment comment = new Comment();
    comment.setAuthor("Elmer Fudd");
    comment.setText("Be very quiet!!");

    String expectedSendMessage = "Email comment from Author: Elmer Fudd with text: Be very quiet!!";
    String expectedStoreMessage = "Inserted comment with Author: Elmer Fudd and text: Be very quiet!!";
    String expected = expectedSendMessage + " " + expectedStoreMessage;

    EmailCommentNotificationProxy emailCommentNotificationProxy = new EmailCommentNotificationProxy();
    DBCommentRepository dbCommentRepository = new DBCommentRepository();

    CommentService commentService = new CommentService(
        emailCommentNotificationProxy,
        dbCommentRepository
    );

    assertEquals(expected, commentService.publishComment(comment));
  }
}
