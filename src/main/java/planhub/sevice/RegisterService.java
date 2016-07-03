package planhub.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planhub.dao.UserDao;
import planhub.domain.UserAuth;

/**
 * Created by little_sheep on 2016/5/24.
 */
@Service
public class RegisterService {
    @Autowired
    private UserDao userDao;
    public Boolean register(UserAuth userAuth){
        //uid取注册时间的后九位
        long registerTime = System.currentTimeMillis();
        userAuth.setUid(Long.parseLong(Long.toString(registerTime).substring(4)));
        userAuth.setTimeStamp(registerTime);
        return userDao.insertUser(userAuth);
    }
}
