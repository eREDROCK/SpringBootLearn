package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController{

  @GetMapping("/hello")
  public String getHello(){
    //hello.htmlに遷移
    return "hello";
  }

  @PostMapping("/hello")
  public String postRequest(@RequestParam("text1") String str, Model model){

    model.addAttribute("sample",str);

    return "response";
  }
}