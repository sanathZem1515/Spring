package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{

	@Autowired
	private CustomerService customerService;



	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
//		get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();

//		add the customers to the model
		theModel.addAttribute("customers",theCustomers);

		return "list-customers";
	}


	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer",theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid  @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult)
	{

		// save the customer using our service
		System.out.println("Binding Result "+theBindingResult);
		System.out.println("\n\n\n");
		if(theBindingResult.hasErrors())
		{
//            System.out.println(theBindingResult.hasErrors());
			return "customer-form";
		}
		else
		{
          	customerService.saveCustomer(theCustomer);
			return "redirect:/customer/list";
		}


	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel)
	{
//		get the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);
//		set customer as model attribute to pre populate the form
		theModel.addAttribute("customer",theCustomer);
//		send over to the form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId,Model theModel)
	{
		customerService.delete(theId);
		return "redirect:/customer/list";
	}
	
}


