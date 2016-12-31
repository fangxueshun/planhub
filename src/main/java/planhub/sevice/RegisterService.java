package planhub.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import planhub.dao.UserDao;
import planhub.domain.User;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by little_sheep on 2016/5/24.
 */
@Service
public class RegisterService {
    @Autowired
    private UserDao userDao;
    private Random random = new SecureRandom();

    public Boolean register(User user) {
        //uid由13位时间戳加3位随机数字组成
        long registerTime = System.currentTimeMillis();
        if (userDao.exists(new Query(Criteria.where("email").is(user.getEmail())))) {
            return false;
        }
        user.setUid(Long.parseLong(Long.toString(registerTime) + Integer.toString(random.nextInt(999))));
        user.setRegisterTime(registerTime);
        return userDao.insertUser(user);
    }
}
