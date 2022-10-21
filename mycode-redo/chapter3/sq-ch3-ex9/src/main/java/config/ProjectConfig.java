package config;

import beans.Parrot;
import beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
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
  Person person(@Qualifier("parrot2") Parrot parrot) {
    var p = new Person();
    p.setName("Ellie");
    p.setParrot(parrot);
    return p;
  }
}
