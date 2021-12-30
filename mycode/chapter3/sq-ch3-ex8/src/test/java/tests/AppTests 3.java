package tests;

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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {
    private String[] expected, results;
    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that two Parrot instances exist in the Spring context")
    public void testSpringContextHasTwoParrotInstances() {
        Parrot p1 = context.getBean("parrot1", Parrot.class);
        Parrot p2 = context.getBean("parrot2", Parrot.class);
        expected = new String[]{"Koko", "Miki"};
        results = new String[]{p1.getName(), p2.getName()};
        assertArrayEquals(expected, results);
    }

    @Test
    @DisplayName("Test that the Person has a parrot2 Parrot instance")
    public void testPersonInstanceHasParrotTwoInstance() {
        Person p = context.getBean(Person.class);
        expected = new String[]{"Ella", "Miki"};
        results = new String[]{p.getName(), p.getParrot().getName()};
        assertArrayEquals(expected, results);
    }
}
