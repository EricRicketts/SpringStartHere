package main;

import config.ProjectConfig;
import beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person p = context.getBean(Person.class);
        System.out.println("Person: " + p.getName() + " Parrot: " + p.getParrot().getName());
    }
}