package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {

  public static void main(String[] args) {
    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

    var cs = c.getBean( CommentService.class);
    var us = c.getBean(UserService.class);

    var crp1 = cs.getCommentRepository();
    var crp2 = us.getCommentRepository();
    System.out.println(crp1 == crp2);
  }
}
