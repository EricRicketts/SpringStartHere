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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

  @Autowired
  private ApplicationContext context;

  @Test
  @DisplayName("context provides a way to obtain a bean by stereotype annotations")
  public void testLabelBeanByStereotype() {
    var p = context.getBean(Parrot.class);
  }
}
