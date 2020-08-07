package com.icia.board.service;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
@Component
public class memberMM {

	public ModelAndView access() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","로그인실패");//어디서든 만들수있다. 
		mav.setViewName("home");
		return mav;
	}


	
}
