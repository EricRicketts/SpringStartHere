package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p1 = context.getBean("parrot1", Parrot.class),
                p2 = context.getBean(Parrot.class),
                p3 = context.getBean("parrot3", Parrot.class);
        System.out.println(p1.getName() + " " + p2.getName() + " " + p3.getName());
    }
}
