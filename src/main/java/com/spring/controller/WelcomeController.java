package com.spring.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.ProducttypeService;

@Controller
public class WelcomeController {

	
	@Autowired
	private ProducttypeService producttypeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginPage1(ModelMap model, HttpServletResponse response) throws IOException {
		/*model.put("products", productDAOImpl.listProducts());
		return "products5";*/
		/*return "test";*/
		
		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		
		/*return "home";*/
		/*response.sendRedirect("/viewproductlist/1/1/9");*/
		return new ModelAndView("redirect:/views/viewproductlist/1/1/9");
	}

}
