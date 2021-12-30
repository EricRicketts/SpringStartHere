package main;

import model.Comment;
import repositories.DBCommentRepository;
import proxies.EmailCommentNotificationProxy;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);
        var comment = new Comment();
        comment.setAuthor("Wendy");
        comment.setText("has a unique relationship with Emma, her daughter");

        commentService.publishComment(comment);
    }
}
