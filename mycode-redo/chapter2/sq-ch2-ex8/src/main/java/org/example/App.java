package org.example;

import config.ProjectConfig;
import main.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class App {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var x = new Parrot();
    Supplier<Parrot> parrotSupplier = () -> x;
    context.registerBean(
        "parrot1",
        Parrot.class,
        parrotSupplier
    );
    var p = context.getBean(Parrot.class);
    System.out.println(p.getName());
  }
}
