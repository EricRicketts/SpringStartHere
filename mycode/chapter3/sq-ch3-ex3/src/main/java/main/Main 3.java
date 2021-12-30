package main;

import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person p = context.getBean(Person.class);
        var personName = p.getName();
        var parrotName = p.getParrot().getName();
        System.out.println("Person name: " + personName + ", Parrot name: " + parrotName);
    }
}
