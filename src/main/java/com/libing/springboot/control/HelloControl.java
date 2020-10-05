package com.libing.springboot.control;

import com.libing.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author libing
 * @create 2020-09-20 15:22
 */
@Controller
public class HelloControl {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @RequestMapping("/success")
    public String success(Map<String ,Object> map){
        map.put("hello","这是一个map");
        return "dashboard";
    }

    // 访问当前项目或者当前项目下的inde.html都来到这里
    /*@RequestMapping({"/","/login.html"})
    public String index(){
        return "index";
    }*/

    @RequestMapping("/crud")
    public String success(@RequestParam("username") String username){
      if("aaa".equals(username)){
          throw new UserNotExistException();
      }
        return "dashboard";
    }

}
