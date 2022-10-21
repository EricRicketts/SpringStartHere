package org.example;

import config.ProjectConfig;
import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var parrot = context.getBean(Parrot.class);
    var person = context.getBean(Person.class);

    System.out.println(parrot.getName());
    System.out.println(person.getName());
    System.out.println(person.getParrot() == parrot);
  }
}
