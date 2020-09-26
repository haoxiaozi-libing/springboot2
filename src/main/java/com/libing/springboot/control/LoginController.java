package com.libing.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;

@Controller
public class LoginController {
@PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String ,Object> map,HttpSession session ) {
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或者密码错误");
            return "login";
        }
    }


//    @DeleteMapping
//    @PutMapping
//    @GetMapping

//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
//    @PostMapping(value = "/user/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Map<String,Object> map, HttpSession session){
//        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
//            //登陆成功，防止表单重复提交，可以重定向到主页
//            session.setAttribute("loginUser",username);
//            return "redirect:/dashboard.html";
//        }else{
//            //登陆失败
//
//            map.put("msg","用户名密码错误");
//            return  "login";
//        }
//
//    }
}