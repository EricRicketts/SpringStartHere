package main;

import model.Comment;
import configuration.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Comment comment = new Comment();
        comment.setAuthor("Wendy");
        comment.setText("has a unique relationship with Emma, her daughter.");

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
