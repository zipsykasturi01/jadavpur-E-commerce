package com.niit.Frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.DAO.CartLinesDAO;

@Controller
@RequestMapping(value="/cart")
public class CartController 
{
	
	@Autowired
	CartLinesDAO cartlinesDAO;
	@RequestMapping(value="/show")
	public ModelAndView showCart()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("userclickshowcart",true);
		mv.addObject("title" , "Online Shopping - User Cart");
		
		mv.addObject("cartlines" , cartlinesDAO.listAvailable(1) );
		return mv;
	}
}
