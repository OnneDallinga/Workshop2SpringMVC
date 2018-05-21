package wine.controllers;

import java.security.Principal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.configuration.CustomerForm;
import wine.domain.Account;
import wine.domain.Customer;
import wine.repositories.AccountRepository;
import wine.repositories.CustomerRepository;

@Slf4j
@Controller
@RequestMapping
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("/customers/all")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAll());
		return "customers/customers";
	}

	@GetMapping("/customers/{id}/show")
	public String showCustomerById(@PathVariable Long id, Model model) {
		if(customerRepo.findById(id).isPresent()) {
			model.addAttribute("customer", customerRepo.findById(id).get());
		}
		return "customers/show";
	}

	@GetMapping("/customer")
	public String registerForm(Model model, Principal principal) {
		Account account = accountRepo.findByUsername(principal.getName());
		if (!customerRepo.findById(account.getId()).isPresent()) {
			model.addAttribute("customerForm", new CustomerForm());
			return "newcustomer";
		}
		Customer customer = customerRepo.findById(account.getId()).get();
		CustomerForm updateCustomerForm = new CustomerForm();
		updateCustomerForm.setFirstName(customer.getFirstName());
		updateCustomerForm.setLastName(customer.getLastName());
		updateCustomerForm.setLastNamePreposition(customer.getLastNamePreposition());
		updateCustomerForm.setEmail(customer.getEmail());
		updateCustomerForm.setPhoneNumber(customer.getPhoneNumber());
		
		model.addAttribute("customerForm", updateCustomerForm);
		return "updatecustomer";
	}

	@PostMapping("/updatecustomer")
	public String updateCustomer(@Valid CustomerForm customerForm, Errors errors, Principal principal) {
		if (errors.hasErrors()) {
			return "newcustomer";
		}
		Account account = accountRepo.findByUsername(principal.getName());
		Customer customerToBeUpdated = customerRepo.findById(account.getId()).get();
		Customer updatedCustomer = customerForm.updateCustomer(customerToBeUpdated);
		customerRepo.save(updatedCustomer);
		return "redirect:/home";
	}

	@PostMapping("/newcustomer")
	public String processRegistration(@Valid CustomerForm customerForm, Errors errors, Principal principal) {
		Account account = accountRepo.findByUsername(principal.getName());
		if (errors.hasErrors()) {
			return "newcustomer";
		}
		Customer newCustomer = customerForm.createCustomer();
		newCustomer.setAccount(account);
		customerRepo.save(newCustomer);
		return "redirect:/home";
	}
}
