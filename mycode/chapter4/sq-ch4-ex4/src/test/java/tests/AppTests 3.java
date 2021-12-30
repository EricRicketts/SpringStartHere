package tests;

import model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import repositories.CommentRepository;
import proxies.CommentNotificationProxy;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import services.CommentService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AppTests {

    private Comment comment;
    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentNotificationProxy commentNotificationProxy;

    @InjectMocks
    private CommentService commentService;

    @BeforeEach
    public void setUp() {
        comment = new Comment();
    }

    @Test
    @DisplayName("Test that the dependencies of the Customer Service Object are correctly called")
    public void testCommentService() {
        commentService.publishComment(comment);

        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendComment(comment);
    }
}