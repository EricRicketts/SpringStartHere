package repositories;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Author: " + comment.getAuthor() + ", storing comment: " + comment.getText());
    }
}
