package planhub.web;

import com.google.gson.Gson;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import planhub.dao.UserDao;
import planhub.domain.UserAuth;
import planhub.sevice.RegisterService;

/**
 * Created by little_sheep on 2016/5/24.
 */
@Controller
public class RegisterConroller {
    //不能直接new，否则就会注入失败了！！！
    //自动注入一个UserDao的bean
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/v01/user/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

    @ResponseBody
    public String saveUser(@RequestBody UserAuth user){
        if (registerService.register(user)) {
            Gson gson = new Gson();
            return gson.toJson(user);
        }
        else{
            return "注册失败！！";
        }
    }
}
