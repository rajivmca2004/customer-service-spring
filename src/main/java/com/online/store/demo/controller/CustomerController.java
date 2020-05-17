package com.online.store.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.store.demo.model.Customer;
import com.online.store.demo.repository.CustomerRepository;

/**
 * @author rasrivastava
 * @apiNote Customer Micro-Service
 */
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

    @RequestMapping ("/customersdisplay")
    public String fetchCustomers (Model model)
    {
        List<Customer> customerRecords = customerRepository.findAll();

        model.addAttribute("customers", customerRecords);

        return "customers";
    }
    
    @GetMapping("/customers")
    @ResponseBody
    public Object fetchCustomers ()
    {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

}
