package planhub.sevice;

import com.sun.corba.se.impl.protocol.RequestCanceledException;
import com.sun.xml.internal.fastinfoset.stax.events.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import planhub.dao.UserDao;
import planhub.domain.User;

/**
 * Created by Administrator on 2016/7/7.
 */
@Service
public class ModifyService {
    @Autowired
    private UserDao userDao;

    public User modifyService(User user) {
        if(userDao.keyExists("uid",user.getUid())){
            userDao.updateUserField(user.getUid(),"userName",user.getUserName());
            return userDao.getUserByUniqueQuery(Query.query(Criteria.where("uid").is(user.getUid())));
        }
        else {
            throw new RuntimeException("请求uid不存在");
        }
    }
}
