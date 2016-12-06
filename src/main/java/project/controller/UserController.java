package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.dto.User;
import project.service.UserService;

@Controller
@EnableAutoConfiguration
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value= "/", method=RequestMethod.GET)
	@ResponseBody
	 public List<User> getList(){
		List<User> rList = userService.getAllUsers();
		return rList;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postCustormer(@ModelAttribute User user){
		userService.create(user);
		return "success";
	}
	
	@RequestMapping(value="{name}", method=RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable String name){
//		return userService.getByName(name);//jdbc方式
		return userService.getUserbyName(name);//jpa方式
	}
	
	
	public String updateUser(@ModelAttribute User user){
		User user2 = userService.getByName(user.getName());
		if(user2!=null){
			user2.setName(user.getName());
			user2.setAge(user.getAge());
			userService.update(user2);
		}
		return "success";
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable String name) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        userService.deleteByName(name);
        return "success";
    }
	
	@RequestMapping(value="/userTest")
    public String test() {
        return "userJdbcTest";
    }
	
	
}

