package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        Comment c = new Comment();
        c.setAuthor("Natasha");
        c.setText("Demo comment");

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = context.getBean(CommentService.class);

        service.publishComment(c);
    }
}
