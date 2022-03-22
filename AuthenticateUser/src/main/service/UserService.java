import com.authUser.AuthenticateUser.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    
    public User getUser(User user);

    public User insertIntoDatabase(User user);
}