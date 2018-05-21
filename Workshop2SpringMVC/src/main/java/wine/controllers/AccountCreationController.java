package wine.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import lombok.extern.slf4j.Slf4j;
import wine.configuration.RegistrationForm;
import wine.domain.Account;
import wine.domain.Authorities;
import wine.repositories.AccountRepository;
import wine.repositories.AuthorityRepository;

@Slf4j
@Controller
@RequestMapping("/register")
public class AccountCreationController implements ControllerInterface {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthorityRepository authorityRepo;

	@GetMapping
	public String registerForm(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return "register";
	}

	@PostMapping
	public String processRegistration(@Valid RegistrationForm form, Errors errors) {
		
		if (errors.hasErrors()) {
			return "register";
		}
		accountRepo.save(form.toAccount(passwordEncoder));
		authorityRepo.save(new Authorities(accountRepo.findByUsername(form.getUsername()).getId(), form.getUsername()));
		return "redirect:/login";
	}
}
