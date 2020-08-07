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
@Autowired//new ��� �����϶�� ������ ��� Ÿ������ ����
//	@Qualifier("person") 
//	@Resource(name="person")//autowired�� qualifier�� ���̾��� ���� ������ resource�� ����. �̸����� �����
	private Student man;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)//.get�� ������ ����� post�� get�̴�
	public ModelAndView home() {//Locale�� ���� ��� 
		//���� Ŭ����-->DAO ���ٿ�	
		memberMM mm=new memberMM();
		ModelAndView mav=mm.access();
//		res.setCharacterEncoding("utf-8");
		return mav;//������
	}
	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public String access(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "access";//home.jsp�ε� jsp�� ���̸� �ȵȴ�. ��ӵȰ�
	}
	
}
