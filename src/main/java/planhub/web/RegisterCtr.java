package planhub.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import planhub.domain.User;
import planhub.sevice.RegisterService;

import javax.validation.Valid;

/**
 * Created by little_sheep on 2016/5/24.
 */
@Controller
public class RegisterCtr {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    Gson normalGson = new Gson();
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/v01/user/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

    @ResponseBody
    public String saveUser(@RequestBody @Valid User user,BindingResult result){
        if (result.hasErrors())
            return normalGson.toJson(result.getAllErrors());
        else{
            if (registerService.register(user)) {

                return gson.toJson(user);
            }
            else{
                return gson.toJson("注册失败，邮箱已被占用");
            }
        }


    }
}
