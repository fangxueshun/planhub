package planhub.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planhub.dao.UserDao;
import planhub.domain.User;

/**
 * Created by little_sheep on 2016/7/6.
 */
@Service
public class LoginService {
    @Autowired
    private UserDao userDao;
    public boolean login(User user) {
        return userDao.getMatchCount(user.getEmail(),user.getPassword());
    }
}
