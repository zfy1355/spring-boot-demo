package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.exception.MyException;

@Controller
@EnableAutoConfiguration
public class Helloworld {
	Logger log = LoggerFactory.getLogger(Helloworld.class);
	
	public Helloworld(){
		log.info("init Hello success!-------------");
	}
	
	@RequestMapping("/")
	public String login(ModelMap map){
		return "login";
	}
	
	@RequestMapping("/home")
	@ResponseBody
	public String home(){
		log.info("helloworld!");
		return "Hello World";
	}
	
	@RequestMapping("/index")
	public String index(ModelMap map){
		map.put("host", "hello.com");
		return "index";
	}
	
	 @RequestMapping("/hello")
	    public String hello() throws Exception {
	        throw new Exception("发生错误");
	    }

	    @RequestMapping("/json")
	    public String json() throws MyException {
	        throw new MyException("发生错误2");
	    }
}
