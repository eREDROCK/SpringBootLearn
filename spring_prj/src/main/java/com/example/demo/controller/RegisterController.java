package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.RequiredArgsConstructor;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.request.UserRequest;


@Controller
@RequiredArgsConstructor
public class RegisterController{
    private final UserService userService;

    @GetMapping(value="/register")
    public String displayRegister(Model model){
        model.addAttribute("userRequest", new UserRequest());
        return "pokecalist/register";
    }

    @GetMapping(value = "/list")
    public String displayList(Model model) {
        List<User> userlist = userService.searchAll();
        model.addAttribute("userlist", userlist);
        return "users/index";
  }

  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model){
    if(result.hasErrors()){
        List<String>errorList=new ArrayList<String>();
        for(ObjectError error:result.getAllErrors()){
            errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError",errorList);
        model.addAttribute("userRequest", userRequest);
        return "/register";
    }

    userService.create(userRequest);
    return "redirect:/list";
  }
}