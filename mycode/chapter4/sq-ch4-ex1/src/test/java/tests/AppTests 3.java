package tests;

import model.Comment;
import repositories.CommentRepository;
import proxies.CommentNotificationProxy;
import services.CommentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppTests {

    private Comment comment;
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;
    private CommentService commentService;

    @BeforeEach
    public void setUp() {
        comment = mock(Comment.class);
        commentRepository = mock(CommentRepository.class);
        commentNotificationProxy = mock(CommentNotificationProxy.class);
        commentService = new CommentService(commentRepository, commentNotificationProxy);
    }

    @Test
    @DisplayName("Test that the Comment Services correctly delegates" +
            "to the Comment Repository and Comment Notification Proxy")
    public void testCommentService() {
        commentService.publishComment(comment);

        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendComment(comment);
    }
}
