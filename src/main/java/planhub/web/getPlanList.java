package planhub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by little_sheep on 2016/5/15.
 */
@Controller
@RequestMapping("/v0.1")
public class getPlanList {

    @RequestMapping(value = "/user/planlist",method = RequestMethod.GET)

    public  @ResponseBody
    String test(){
        return "check success!";
    }
}
