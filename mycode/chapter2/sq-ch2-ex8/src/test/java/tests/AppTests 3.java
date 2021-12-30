package tests;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    @Test
    @DisplayName("Test create Parrot instance within Spring Context programmatically")
    public void testCreateParrotInstanceProgrammatically() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot x = new Parrot();
        x.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean(
                "parrot1",
                Parrot.class,
                parrotSupplier,
                bc -> bc.setPrimary(true)
        );
        assertTrue(context.containsBeanDefinition("parrot1"));
    }
}
