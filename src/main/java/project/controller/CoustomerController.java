package project.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.domain.Customer;

@Controller
@EnableAutoConfiguration
@RequestMapping(value="/customer")
public class CoustomerController {
	static Map<Long, Customer> customers = Collections.synchronizedMap(new HashMap<Long, Customer>());
	
	@RequestMapping(value= "/", method=RequestMethod.GET)
	 List<Customer> getList(){
		List<Customer> rList = new ArrayList<Customer>();
		return rList;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String postCustormer(@ModelAttribute Customer customer){
		customers.put(customer.getId()	, customer);
		return "success";
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable Long id){
		return customers.get(id);
	}
	
	
	public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer){
		Customer customer2 = customers.get(id);
		if(customer2!=null){
			customer2.setName(customer.getName());
			customer2.setAge(customer.getAge());
			customers.put(id, customer2);
		}
		return "success";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        customers.remove(id);
        return "success";
    }
	
	
}
