package org.example;

import config.ProjectConfig;
import main.Parrot;
import main.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var parrot = new Parrot();
    var person = new Person();

    parrot.setName("Polly");
    person.setName("Ellie");

    System.out.println(parrot.getName());
    System.out.println(person.getName());
    System.out.println(person.getParrot() == null);
  }
}
