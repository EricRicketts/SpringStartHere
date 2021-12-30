package services;

import model.Comment;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void publishComment(Comment comment) {
        logger.info("Author: " + comment.getAuthor() + ", publishing comment: " + comment.getText());
    }
}
