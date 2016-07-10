package planhub.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import planhub.domain.User;
import planhub.sevice.LoginService;
import planhub.sevice.ModifyService;

import javax.rmi.CORBA.Util;
import javax.validation.Valid;

/**
 * Created by little_sheep on 2016/7/6.
 */
@Controller
@RequestMapping("/v01")
public class ModifyUserValueCtr {
    @Autowired
    private ModifyService modifyService;

    //特定字段不进行反序列化
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    @RequestMapping(value = "/user/modify",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")

    @ResponseBody
    public String login(@RequestBody  User user){
        if (StringUtils.isEmpty(user.getUserName())){
            throw new RuntimeException("用户昵称不能为空");
        }
        if (StringUtils.isEmpty(user.getUid())){
            throw new RuntimeException("uid为空");
        }
            return gson.toJson(modifyService.modifyService(user));
    }
}
