package tests;

import model.Comment;
import config.ProjectConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import processors.CommentProcessor;
import services.CommentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    private Comment c;
    @Autowired
    private ApplicationContext context;

    @BeforeEach
    public void setUp() {
        c = new Comment();
        c.setAuthor("Wendy");
        c.setText("has a unique relationship with Emma, her daughter");
    }

    @Test
    @DisplayName("Test that the CommentService Bean is a singleton")
    public void testCommentServiceBeanIsSingleton() {
        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);

        assertEquals(cs1, cs2);
    }

    @Test
    @DisplayName("Test that the CommentProcess Bean is a prototype")
    public void testCommentProcessorBeanIsPrototype() {
        CommentService cs = context.getBean(CommentService.class);
        CommentProcessor cp1 = cs.sendComment(c);
        CommentProcessor cp2 = cs.sendComment(c);

        assertNotEquals(cp1, cp2);
    }

}
