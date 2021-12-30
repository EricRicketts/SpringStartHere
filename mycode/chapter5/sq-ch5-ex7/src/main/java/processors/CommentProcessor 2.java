package processors;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CommentRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

    @Autowired
    private CommentRepository commentRepository;
    private Comment comment;

    public Comment getComment() { return comment; }
    public void setComment(Comment comment) { this.comment = comment; }

    public void processComment(Comment comment) {}
    public void validateComment(Comment comment) {}
}
