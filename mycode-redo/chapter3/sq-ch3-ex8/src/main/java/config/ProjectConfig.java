package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

  @Bean
  Parrot parrot1() {
    var p  = new Parrot();
    p.setName("Koko");
    return p;
  }

  @Bean
  Parrot parrot2() {
    var p  = new Parrot();
    p.setName("Miki");
    return p;
  }

  @Bean
  Person person(Parrot parrot2) {
    var p = new Person();
    p.setName("Ellie");
    p.setParrot(parrot2);
    return p;
  }
}
