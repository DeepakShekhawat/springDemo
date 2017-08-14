package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value ={"/", "/index", "/home"})
public class PageController {

	@RequestMapping(value ={"/", "/index", "/home"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("greeting", "Welcome to Spring web MVC..");
		return mv;
	}
}
