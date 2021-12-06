package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {
}
