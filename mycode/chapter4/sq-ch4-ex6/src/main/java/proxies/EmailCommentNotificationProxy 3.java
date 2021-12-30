package proxies;

import model.Comment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Author: " + comment.getAuthor() +
                ", sending notification for comment: " + comment.getText());
    }
}
