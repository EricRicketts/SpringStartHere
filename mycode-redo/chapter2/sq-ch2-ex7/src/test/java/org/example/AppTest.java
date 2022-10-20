package org.example;


import config.ProjectConfig;
import main.Parrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

  @Autowired
  private ApplicationContext context;

  @Test
  @DisplayName("@PostConstruct can be used to initialize a bean immediately after registering it into the context")
  public void testPostConstructAnnotation() {
    var p = context.getBean(Parrot.class);
    assertEquals("Kiki", p.getName());
  }
}
