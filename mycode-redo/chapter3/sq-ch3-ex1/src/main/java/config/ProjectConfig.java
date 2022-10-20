package config;

import main.Parrot;
import main.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

  @Bean
  Parrot parrot() {
    var p  = new Parrot();
    p.setName("Koko");
    return p;
  }

  @Bean
  Person person() {
    var p = new Person();
    p.setName("Ellie");
    return p;
  }
}
