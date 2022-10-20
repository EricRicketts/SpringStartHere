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
@ContextConfiguration( classes = { ProjectConfig.class })
public class AppTest {
  private String expected;

  @Autowired
  private ApplicationContext context;

  @Test
  @DisplayName("there is an option to designate a primary bean for a context")
  public void testContextHasPrimaryBean() {
    expected = "Koko";
    var p = context.getBean(Parrot.class);
    assertEquals(expected, p.getName());
  }
  @Test
  @DisplayName("there is an option to designate a bean by a method name for a context")
  public void testContextHasBeanByMethodName() {
    expected = "Miki";
    var p = context.getBean("parrot2", Parrot.class);
    assertEquals(expected, p.getName());
  }
  @Test
  @DisplayName("there is an option to designate a bean by @Bean annotation arguments for a context")
  public void testContextHasBeanByAnnotationName() {
    expected = "Riki";
    var p = context.getBean("riki", Parrot.class);
    assertEquals(expected, p.getName());
  }
}
