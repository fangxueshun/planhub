package planhub.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import planhub.domain.User;
import planhub.sevice.LoginService;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by little_sheep on 2016/7/6.
 */
@Controller
public class LonginCtr {
    @Autowired
     private LoginService loginService;

    //特定字段不进行反序列化
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    @RequestMapping (value = "/v01/user/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

    @ResponseBody
    public String login(@RequestBody @Valid User user,BindingResult result){
        if (result.hasErrors())
            return gson.toJson(result.getAllErrors());
        else{
            if (loginService.login(user)) {

                return gson.toJson(user);
            }
            else{
                return "登录失败";
            }
        }
    }
}
