package org.example;

import config.ProjectConfig;
import main.Parrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

  @Test
  @DisplayName("We can register a bean with the context programmatically")
  public void testRegisterBeanProgrammatically() {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var x = new Parrot();
    Supplier<Parrot> parrotSupplier = () -> x;
    context.registerBean(
        "parrot1",
        Parrot.class,
        parrotSupplier
    );
    assertEquals("Koko", context.getBean(Parrot.class).getName());
  }
}
