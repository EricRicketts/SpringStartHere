package tests;

import config.ProjectConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import services.CommentService;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that Prototype Beans are unique instances")
    public void testPrototypeBeansAreUniqueInstances() {
        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);
        assertNotEquals(cs1, cs2);
    }
}
