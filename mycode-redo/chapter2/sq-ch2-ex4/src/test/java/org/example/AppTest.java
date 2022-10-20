package org.example;

import config.ProjectConfig;
import main.Parrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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
  @DisplayName("context has a parrot bean named 'Koko'")
  public void testParrotBeanNamedKoko() {
    expected = "Koko";
    var p = context.getBean("koko", Parrot.class);
    assertEquals(expected, p.getName());
  }

  @Test
  @DisplayName("context has a parrot bean named 'Miki'")
  public void testParrotBeanNamedMiki() {
    expected = "Miki";
    var p = context.getBean("miki", Parrot.class);
    assertEquals(expected, p.getName());
  }

  @Test
  @DisplayName("context has a parrot bean named 'Riki'")
  public void testParrotBeanNamedRiki() {
    expected = "Riki";
    var p = context.getBean("riki", Parrot.class);
    assertEquals(expected, p.getName());
  }

  @Test
  @DisplayName("with name given in bean argument context does not allow bean identification by method name")
  public void testParrotBeanNamedParrot1() {
    assertThrows(NoSuchBeanDefinitionException.class, () -> {
        context.getBean("parrot1", Parrot.class);
    }, "NoSuchBeanDefinition was expected");
  }
}