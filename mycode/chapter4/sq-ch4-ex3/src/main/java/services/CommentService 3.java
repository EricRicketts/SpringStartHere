package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
