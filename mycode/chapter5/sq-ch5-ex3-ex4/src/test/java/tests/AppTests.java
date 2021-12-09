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
import services.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Verify that CommentService every time you request an instance" +
            " from the Spring context, you get the same instance")
    public void testCommentServiceIsSingleton() {
        var cs1 = context.getBean(CommentService.class);
        var cs2 = context.getBean(CommentService.class);

        assertEquals(cs1, cs2);
    }

    @Test
    @DisplayName("Verify that CommentService every time you request an instance" +
            " from the Spring context, you get the same instance")
    public void testUserServiceIsSingleton() {
        var us1 = context.getBean(UserService.class);
        var us2 = context.getBean(UserService.class);

        assertEquals(us1, us2);
    }

}
