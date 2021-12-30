package main;

import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);
        System.out.println("Person: " + person.getName() + ", Parrot: " + parrot.getName() +
                ", Person's parrot: " + person.getParrot().getName());
    }
}