package com.mmi.review.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class Errorcontroller {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handelException(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", ex.getStackTrace());
		mv.addObject("url", request.getRequestURI());
		mv.setViewName("error");
		return mv;
	}
}
