package org.example;

import config.ProjectConfig;
import main.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main( String[] args ) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var p = context.getBean(Parrot.class);
    var s = context.getBean(String.class);
    var i = context.getBean(Integer.class);

    System.out.println(p.getName());
    System.out.println(s);
    System.out.println(i);
  }
}
