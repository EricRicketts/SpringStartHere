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
    @DisplayName("Test a Parrot instance is in the Spring Context")
    public void testParrotInstanceInSpringContext() {
        Parrot p = context.getBean(Parrot.class);
        assertNotNull(p);
    }

    @Test
    @DisplayName("Test a Person instance from Spring Context has a Parrot attribute")
    public void testPersonInstanceHasParrotAttribute() {
        Person p = context.getBean(Person.class);
        assertNotNull(p.getParrot());
    }
}
