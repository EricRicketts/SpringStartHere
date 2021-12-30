package main;

import model.Comment;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import processors.CommentProcessor;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Comment c = new Comment();
        c.setAuthor("Wendy");
        c.setText("has a unique relationship with Emma, her daughter.");
        CommentService cs = context.getBean(CommentService.class);
        CommentProcessor cp1 = cs.sendComment(c);
        CommentProcessor cp2 = cs.sendComment(c);

        System.out.println(cp1 != cp2);
    }
}
