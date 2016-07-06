package planhub.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public Boolean login(User user) {
        Query objectCount = new Query(Criteria.where("email").is(user.getEmail()).andOperator(Criteria.where("password").is(user.getPassword())));
        Query userObject = new Query(Criteria.where("email").is(user.getEmail()));
        if (userDao.getObjectCount(objectCount)==1){
            User daoUser = userDao.getUserByUniqueQuery(userObject);
            user.setUid(daoUser.getUid());
            user.setUserName(daoUser.getUserName());
            return true;
        }
        else {
            return false;
        }
    }
}
