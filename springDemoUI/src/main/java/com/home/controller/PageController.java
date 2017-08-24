package com.home.controller;

import home.spring.shoppingserver.dao.CategoryDAO;
import home.spring.shoppingserver.dao.ProductDAO;
import home.spring.shoppingserver.dto.Category;
import home.spring.shoppingserver.dto.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.home.exception.ProductNotFoundException;
@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/index", "/home"})
	public ModelAndView index(){
		
		logger.info("inside PageController index for INFO");
		logger.debug("inside PageController index for DEBUG");
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
	
	/*
	 * Method to show individual product
	 */
	@RequestMapping(value= {"show/{id}/product"})
	public ModelAndView showUniqProduct(@PathVariable("id") int id) throws ProductNotFoundException{
		Product product = null;
		product=  productDAO.getProduct(id);
		
		if(product==null){
			
			throw new ProductNotFoundException();
		}
		
		product.setViews(product.getViews() + 1);
		productDAO.updateProduct(product);
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", product.getName());
		mv.addObject("userClickViewProduct", true);
		mv.addObject("product", product);
		return mv;
	}
	
}
