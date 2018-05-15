package wine.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.configuration.CustomerForm;
import wine.configuration.RegistrationForm;
import wine.domain.Account;
import wine.domain.Customer;
import wine.repositories.AccountRepository;
import wine.repositories.CustomerRepository;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping
	public String registerForm(Model model) {
		model.addAttribute("customerForm", new CustomerForm());
		//model.addAttribute("registrationForm", new RegistrationForm());
		return "customer";
	}

	@PostMapping
	public String processRegistration(@Valid CustomerForm customerForm,
			Errors errors, Principal principal) {
		
		Account account = accountRepo.findByUsername(principal.getName());
		
		if (errors.hasErrors()) {
			return "customer";
		}
		
		Customer newCustomer = customerForm.createCustomer();
		newCustomer.setAccount(account);
		
		//accountRepo.save(registrationForm.toAccount(passwordEncoder));
		customerRepo.save(newCustomer);
		return "redirect:/customer";
	}
}
