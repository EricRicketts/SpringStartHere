package tests;

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
@ContextConfiguration( classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that Parrot instance parrot1 has name Koko")
    public void testParrot1HasNameKoko() {
        var p = context.getBean("parrot1", Parrot.class);
        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance miki has name Miki")
    public void testMikiHasNameMiki() {
        var p = context.getBean("miki", Parrot.class);
        assertEquals("Miki", p.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance parrot3 has name Riki")
    public void testParrot3HasNameRiki() {
        var p = context.getBean("parrot3", Parrot.class);
        assertEquals("Riki", p.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance parrot2 does not exist")
    public void testParrot2DoesNotExist() {
        // NoSuchBeanDefinitionException
        Exception exception = assertThrows(NoSuchBeanDefinitionException.class, () -> {
            var p = context.getBean("parrot2", Parrot.class);
        }, "Expected a NoSuchBeanDefinitionException to be thrown");

        assertEquals("No bean named 'parrot2' available", exception.getMessage());
    }
}
