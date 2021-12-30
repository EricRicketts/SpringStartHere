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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test a Parrot instance is in the Spring Context")
    public void testParrotInstanceInSpringContext() {
        var p = context.getBean(Parrot.class);
        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test a Person instance owns a Parrot instance in the Spring Context")
    public void testPersonOwnsParrot() {
        var p = context.getBean(Person.class);
        String[] expected = {"Ella", "Koko"};
        String[] results = {p.getName(), p.getParrot().getName()};
        assertArrayEquals(expected, results);
    }
}
