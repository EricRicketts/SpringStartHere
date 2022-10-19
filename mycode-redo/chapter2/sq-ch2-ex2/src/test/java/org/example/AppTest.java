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
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTest {
  private String expectedString;
  private Integer expectedInteger;
  @Autowired
  private ApplicationContext context;

  @Test
  @DisplayName("Test that a Parrot Bean with name Koko has been added to the Spring Context")
  public void testParrotBeanIsInSpringContext() {
    expectedString = "Koko";
    var p = context.getBean(Parrot.class);
    assertEquals(expectedString, p.getName());
  }

  @Test
  @DisplayName("Test that a String Bean with value 'Hello' has been added to the Spring context")
  public void testStringBeanIsInSpringContext() {
    expectedString = "Hello";
    assertEquals(expectedString, context.getBean(String.class));
  }

  @Test
  @DisplayName("Test that a Integer Bean with value 10 has been added to the Spring context")
  public void testIntegerBeanIsInSpringContext() {
    expectedInteger = 10;
    assertEquals(expectedInteger, context.getBean(Integer.class));
  }
}
