package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = {"proxies", "repositories", "services"})
public class ProjectConfiguration {
}
