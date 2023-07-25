package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController{

  @RequestMapping("/hello")
  public String getHello(){
    //hello.htmlに遷移
    return "hello";
  }
}