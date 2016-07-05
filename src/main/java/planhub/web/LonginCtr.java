package planhub.web;

import com.google.gson.Gson;
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
    Gson gson = new Gson();
    @RequestMapping (value = "/v01/user/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

    @ResponseBody
    public String longin(@RequestBody @Valid User user,BindingResult result){
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
