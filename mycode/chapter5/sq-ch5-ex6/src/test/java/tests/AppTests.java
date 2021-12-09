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
import repositories.CommentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that prototype beans are not the same instance using stereotype annotations")
    public void testPrototypeBeansNotIdentical() {
        var r1 = context.getBean("commentRepository", CommentRepository.class);
        var r2 = context.getBean("commentRepository", CommentRepository.class);
        assertNotEquals(r1, r2);
    }

    @Test
    @DisplayName("Test that the Comment Repositories from the User Service and Comment Service are different")
    public void testCommentRepositoriesAreDifferent() {
        var cs = context.getBean("commentService", CommentService.class);
        var us = context.getBean("userService", UserService.class);

        var crp1 = cs.getCommentRepository();
        var crp2 = us.getCommentRepository();
        assertNotEquals(crp1, crp2);
    }
}
