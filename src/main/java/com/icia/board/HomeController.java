package com.icia.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.bean.Person;
import com.icia.board.bean.Student;
import com.icia.board.service.memberMM;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
@Autowired//new 대신 주입하라는 스프링 용어 타입으로 주입
//	@Qualifier("person") 
//	@Resource(name="person")//autowired랑 qualifier를 같이쓰고 싶지 않으면 resource를 쓴다. 이름으로 끌고옴
	private Student man;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)//.get은 보내는 방식인 post와 get이다
	public ModelAndView home() {//Locale은 국가 담당 
		//서비스 클래스-->DAO 갔다옴	
		memberMM mm=new memberMM();
		ModelAndView mav=mm.access();
//		res.setCharacterEncoding("utf-8");
		return mav;//포워딩
	}
	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public String access(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "access";//home.jsp인데 jsp를 붙이면 안된다. 약속된것
	}
	
}
