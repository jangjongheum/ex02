package com.icia.board.service;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
@Component
public class memberMM {

	public ModelAndView access() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","�α��ν���");//��𼭵� ������ִ�. 
		mav.setViewName("home");
		return mav;
	}


	
}
