package planhub.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import planhub.domain.User;
import planhub.sevice.LoginService;

import javax.validation.Valid;

/**
 * Created by little_sheep on 2016/7/6.
 */
public class ModifyUserValue {
    @Autowired
    private LoginService loginService;

    //特定字段不进行反序列化
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//    @RequestMapping(value = "/v01/user/modify",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

//    @ResponseBody
//    public String login(@RequestBody @Valid Map<String,Object>, BindingResult result){
//        if (result.hasErrors())
//            return gson.toJson(result.getAllErrors());
//        else{
//            if (loginService.login(user)) {
//
//                return gson.toJson(user);
//            }
//            else{
//                return "登录失败";
//            }
//        }
//    }
}
