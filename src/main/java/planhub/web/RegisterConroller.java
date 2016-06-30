package planhub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import planhub.dao.UserDao;

/**
 * Created by little_sheep on 2016/5/24.
 */
@Controller
public class RegisterConroller {
    UserDao userDao=new UserDao();
    @RequestMapping(value = "/v01/user/register",method = RequestMethod.GET)

    public  @ResponseBody
    String test(){
        userDao.register("abc","password");
        return "check success!";
    }
}
