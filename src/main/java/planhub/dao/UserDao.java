package planhub.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import planhub.domain.UserAuth;

/**
 * Created by little_sheep on 2016/5/24.
 */
//通过注解定义一个DAO
@Repository
public class UserDao {
    //自动注入一个MongoTemplate的bean
    @Autowired
    private MongoTemplate mongoTemplate;
    UserAuth user = new UserAuth();
    public boolean register(String emial,String password){
        user.setEmail(emial);
        user.setPassword(password);
        mongoTemplate.insert(user,"users");
        return true;
    }
}
