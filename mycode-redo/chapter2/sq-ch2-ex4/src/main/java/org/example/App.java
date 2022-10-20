package org.example;

import main.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var p1 = context.getBean("koko", Parrot.class);
    var p2 = context.getBean("miki", Parrot.class);
    var p3 = context.getBean("riki", Parrot.class);

    System.out.println(p1.getName());
    System.out.println(p2.getName());
    System.out.println(p3.getName());
  }
}
