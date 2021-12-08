package proxies;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Author: " + comment.getAuthor() +
                ", sending push notification for comment: " + comment.getText());
    }
}
