package proxies;

import model.Comment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Author: " + comment.getAuthor() +
                ", sending push notification for comment: " + comment.getText());
    }
}
