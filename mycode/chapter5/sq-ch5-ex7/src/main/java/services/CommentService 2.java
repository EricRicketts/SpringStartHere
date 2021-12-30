package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;

@Service
public class CommentService {

    @Autowired
    private ApplicationContext context;

    public CommentProcessor sendComment(Comment c) {
        CommentProcessor p = context.getBean(CommentProcessor.class);

        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
        return p;
    }
}
