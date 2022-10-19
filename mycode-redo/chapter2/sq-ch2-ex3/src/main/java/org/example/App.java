package org.example;

import main.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { ProjectConfig.class })
public class App {
  public static void main( String[] args ) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var p1 = context.getBean("parrot1", Parrot.class);
    var p2 = context.getBean("parrot2", Parrot.class);
    var p3 = context.getBean("parrot3", Parrot.class);

    System.out.println(p1.getName());
    System.out.println(p2.getName());
    System.out.println(p3.getName());
  }
}
