package main;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;
import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        service.publishComment(comment);

    }
}