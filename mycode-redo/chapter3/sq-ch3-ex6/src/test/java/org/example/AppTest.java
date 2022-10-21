package org.example;

import config.ProjectConfig;
import beans.Parrot;
import beans.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {
  private String expected;

  @Autowired
  private ApplicationContext context;

  @Test
  @DisplayName("context has a parrot bean")
  public void testContextHasParrotBean() {
    assertTrue(context.containsBean("parrot"));
  }

  @Test
  @DisplayName("context has a person bean")
  public void testContextHasPersonBean() {
    assertTrue(context.containsBean("person"));
  }

  @Test
  @DisplayName("context has a person bean with a parrot instance")
  public void testContextHasPersonBeanWithParrotInstance() {
    var person = context.getBean("person", Person.class);
    var parrot = context.getBean("parrot", Parrot.class);
    assertEquals(parrot, person.getParrot());
  }
}
