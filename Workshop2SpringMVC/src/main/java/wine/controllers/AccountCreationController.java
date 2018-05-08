package wine.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.configuration.RegistrationForm;
import wine.repositories.AccountRepository;

@Slf4j
@Controller
@RequestMapping("/register")
public class AccountCreationController implements ControllerInterface {

	private AccountRepository accountRepo;
	private PasswordEncoder passwordEncoder;

	public AccountCreationController(AccountRepository accountRepo, PasswordEncoder passwordEncoder) {
		this.accountRepo = accountRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	public String registerForm() {
		return "register";
	}

	@PostMapping
	public String processRegistration(RegistrationForm form) {
		accountRepo.save(form.toAccount(passwordEncoder));
		return "redirect:/login";
	}
}
