package com.libing.springboot.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libing
 * @create 2020-09-20 15:22
 */
@RestController
public class HelloControl {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


}
