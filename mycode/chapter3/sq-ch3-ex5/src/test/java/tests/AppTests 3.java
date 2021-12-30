package tests;

import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that a Parrot instance is in the Spring Context")
    public void testParrotInstanceInSpringContext() {
        assertNotNull(context.getBean(Parrot.class));
    }

    @Test
    @DisplayName("Test that a Person instance in the Spring Context has a Parrot attribute")
    public void testPersonInstanceHadParrotAttribute() {
        assertNotNull(context.getBean(Person.class).getParrot());
    }

}
