package com.kgisl.beanscopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.SystemEnvironmentPropertySourceEnvironmentPostProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	@Autowired
	private Customer customer;
 
    @RequestMapping("/")
	public String name1() {
        String result = customer.getCustomerName();
        customer.customerDetails();
		return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerName();
	}
	@RequestMapping("/name")
	public String name() {
        String result = customer.getCustomerName();
     
        customer.setCustomerName("Adam", "Johnson");
        customer.nameDetails();
		return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerName();
	}
 
	@RequestMapping("/namecheck")
	public String namecheck() {
        
		return "check Data: " + customer.getCustomerName();
	}
 
	@RequestMapping("/language")
	public String language() {
       
        String result = customer.getCustomerLanguage();
        customer.languageDetails();
		//customer.setCustomerLanguage("French") //this command creates new instance of Language
		return "init Data: " + result + "|-----| modified Data: " + customer.setCustomerLanguage("French");
	}
 
	@RequestMapping("/languagecheck")
	public String languagecheck() {
		return "check Data: " + customer.getCustomerLanguage();
	}
 
	@RequestMapping("/address")
	public String address() {
        String result = customer.getCustomerAddress();
        customer.setCustomerAddress("EU");
        customer.addressDetails();
		return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAddress();
	}
 
	@RequestMapping("/addresscheck")
	public String addresscheck() {
		return "check Data: " + customer.getCustomerAddress();
	}
	
	@RequestMapping("/age")
	public String age() {
		String result = customer.getCustomerAge();
        customer.setCustomerAge("25");
        customer.ageDetails();
		return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAge();
	}
 
	@RequestMapping("/agecheck")
	public String agecheck() {
		return "check Data: " + customer.getCustomerAge();
	}
}