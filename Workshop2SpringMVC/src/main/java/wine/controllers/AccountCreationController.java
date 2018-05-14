package wine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;
import wine.configuration.RegistrationForm;
import wine.domain.Account;
import wine.repositories.AccountRepository;

@Slf4j
@Controller
@RequestMapping("/register")
public class AccountCreationController implements ControllerInterface {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public String registerForm(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return "register";
	}

	@PostMapping
	public String processRegistration(RegistrationForm form) {
		accountRepo.save(form.toAccount(passwordEncoder));
		return "redirect:/login";
	}
}
