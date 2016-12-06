package project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.dto.User;
import project.exception.MyException;

@Controller
public class Login {
	Logger log = LoggerFactory.getLogger(Login.class);
	
	public Login(){
		log.info("init Login controller success!-------------");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, User user){
		request.getSession().setAttribute("username", user.getName());
		return "/success";
	}
	
	/**
	 * session共享
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/session", method=RequestMethod.GET)
	@ResponseBody
	public Object getSession(HttpServletRequest request, User user){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("username"));
		return map;
	}
	
}
