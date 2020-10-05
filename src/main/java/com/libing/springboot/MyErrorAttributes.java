package com.libing.springboot;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author libing
 * @create 2020-10-05 11:28
 */

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","lvlibing");
        Map<String,Object> ext=( Map<String,Object>)requestAttributes.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
