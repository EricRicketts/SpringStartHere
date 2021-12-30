package services;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

@Service
@Lazy
public class UserService {
    public UserService() {
        System.out.println("UserService instance created!");
    }
}
