package org.example;

import main.Parrot;
import config.ProjectConfig;
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

  private String expected;
  @Autowired
  private ApplicationContext context;

  @Test
  @DisplayName("Context has a parrot1 bean")
  public void testParrot1HasNameKoko() {
    expected = "Koko";
    var p = context.getBean("parrot1", Parrot.class);
    assertEquals(expected, p.getName());
  }

  @Test
  @DisplayName("Context has a parrot2 bean")
  public void testParrot2HasNameMiki() {
    expected = "Miki";
    var p = context.getBean("parrot2", Parrot.class);
    assertEquals(expected, p.getName());
  }

  @Test
  @DisplayName("Context has a parrot3 bean")
  public void testParrot3HasNameKoko() {
    expected = "Riki";
    var p = context.getBean("parrot3", Parrot.class);
    assertEquals(expected, p.getName());
  }
}
