package tests;

import config.ProjectConfig;
import main.Parrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that the Parrot instance parrot1 has name Koko")
    public void testParrot1HasNameKoko() {
        Parrot p = context.getBean("parrot1", Parrot.class);
        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that the Parrot instance parrot2 has name Koko")
    public void testParrot2HasNameMiki() {
        Parrot p = context.getBean("parrot2", Parrot.class);
        assertEquals("Miki", p.getName());
    }

    @Test
    @DisplayName("Test that the Parrot instance parrot1 has name Koko")
    public void testParrot3HasNameRiki() {
        Parrot p = context.getBean("parrot3", Parrot.class);
        assertEquals("Riki", p.getName());
    }
}
