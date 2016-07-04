package planhub.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planhub.dao.UserDao;
import planhub.domain.User;

/**
 * Created by little_sheep on 2016/5/24.
 */
@Service
public class RegisterService {
    @Autowired
    private UserDao userDao;
    public Boolean register(User user){
        //uid取注册时间的后九位
        long registerTime = System.currentTimeMillis();
        user.setUid(Long.parseLong(Long.toString(registerTime).substring(4)));
        user.setRegisterTime(registerTime);
        if (!userDao.keyExists("uid", user.getUid())){
            userDao.insertUser(user);
            return userDao.keyExists("uid", user.getUid());
        }
        else {
            return false;
        }
    }
}
