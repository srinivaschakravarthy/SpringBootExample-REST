package com.example.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
 @RequestMapping("/hello")
 public String Hello(Model model) {
	 String str = new String();
	 str = "A tempo wala string";
	 model.addAttribute("key", str);
	 return "Hello";
 }
}
