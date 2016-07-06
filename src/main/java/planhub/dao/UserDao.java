package planhub.dao;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import planhub.domain.User;

/**
 * Created by little_sheep on 2016/5/24.
 *
 */
@Repository
public class UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    private final static String COLLECTION_NAME="users";

    //添加用户
    public void insertUser(User user){
        mongoTemplate.insert(user,COLLECTION_NAME);
    }

    //判断记录实体是否存在
    public Boolean exists(Query query){
        return mongoTemplate.exists(query,User.class,COLLECTION_NAME);

    }

    //查询字段是否存在
    public boolean keyExists(String key,Object value){
        return mongoTemplate.exists(new Query(Criteria.where(key).is(value)),User.class,COLLECTION_NAME);
    }

    //更新用户某个字段
    //TODO 测试该接口
    public WriteResult updateUserField(long uid,String field,Object value){
        return  mongoTemplate.updateFirst(new Query(Criteria.where("uid").is(uid)), Update.update(field,value),User.class,COLLECTION_NAME);
    }

    //获取符合条件的用户单条数据
    public User getUserByUniqueQuery(Query query){
        return mongoTemplate.findOne(query,User.class,COLLECTION_NAME);
    }

    //获取符合条件的记录数量
    public Long getObjectCount(Query query){
        return mongoTemplate.count(query,User.class,COLLECTION_NAME);
    }
}
