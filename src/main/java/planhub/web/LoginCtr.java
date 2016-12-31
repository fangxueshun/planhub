package planhub.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import planhub.domain.User;
import planhub.sevice.LoginService;
import planhub.util.RestResponseException;

import javax.validation.Valid;

/**
 * Created by little_sheep on 2016/7/6.
 */
@Controller
@RequestMapping("/v0.1")
public class LoginCtr {
    @Autowired
    private LoginService loginService;

    //特定字段不进行反序列化
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    Gson normalGson = new Gson();

    //EncryptWithMD5 encryptWithMD5 = new EncryptWithMD5();
    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")

    @ResponseBody
    public String login(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors())
            return normalGson.toJson(result.getAllErrors());
        else {
            //user.setPassword(encryptWithMD5.makeMD5(user.getPassword()));
            if (loginService.login(user)) {

                return gson.toJson(user);
            } else {
                throw new RestResponseException("BAD_REQUEST", "邮箱已被注册");
            }
        }
    }
}
