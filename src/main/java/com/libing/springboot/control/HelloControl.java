package com.libing.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "hello";
    }

    // 访问当前项目或者当前项目下的inde.html都来到这里
   /* @RequestMapping({"/","/login.html"})
    public String index(){
        return "index";
    }
*/
}
