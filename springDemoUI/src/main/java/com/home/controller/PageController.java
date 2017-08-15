package com.home.controller;

import home.spring.shoppingserver.dto.Category;
import home.spring.springserver.dao.CategoryDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/index", "/home"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
		
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAbout", true);
		mv.addObject("title", "About Us");
		return mv;
		
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
		
	}
	
	/*
	 * Method to load all products or based on category
	 */
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	/*
	 * Method to load all products or based on category
	 */
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showproductsByCategory(@PathVariable("id") int id){
		Category category = null;
		category = categoryDAO.getCategory(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		return mv;
	}
}
