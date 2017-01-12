package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YunZhang on 12/1/17.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "/index.html";
    }
}
