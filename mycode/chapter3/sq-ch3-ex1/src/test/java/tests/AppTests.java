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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that a Parrot instance is in the Spring Context")
    public void testParrotInstanceInSpringContext() {
        var p = context.getBean(Parrot.class);
        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that a Person instance is in the Spring Context")
    public void testPersonInstanceInSpringContext() {
        var p = context.getBean(Person.class);
        assertEquals("Ella", p.getName());
    }

    @Test
    @DisplayName("Test that a Person instance does not have a Parrot attribute")
    public void testPersonInstanceDoesNotHaveAParrotAttribute() {
        var p = context.getBean(Person.class);
        assertNull(p.getParrot());
    }
}
