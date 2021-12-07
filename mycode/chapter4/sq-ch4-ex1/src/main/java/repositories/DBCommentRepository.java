package repositories;

import model.Comment;

public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Author: " + comment.getAuthor() + ", Storing comment: " + comment.getText());
    }
}
