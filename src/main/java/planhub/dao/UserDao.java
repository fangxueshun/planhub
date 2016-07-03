package planhub.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    private final static String COLLECTION_NAME="users";
    public boolean insertUser(UserAuth userAuth){
        mongoTemplate.insert(userAuth,COLLECTION_NAME);
        Query has_uid=new Query(Criteria.where("uid").is(userAuth.getUid()));
        return mongoTemplate.exists(has_uid,UserAuth.class,COLLECTION_NAME);
    }
}
