package planhub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by little_sheep on 2016/5/15.
 */
@Controller
public class getPlanList {

    @RequestMapping(value = "/v01/user/register",method = RequestMethod.GET)

    public  @ResponseBody
    String test(){
        return "check success!";
    }
}
