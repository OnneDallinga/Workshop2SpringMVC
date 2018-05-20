package wine.controllers;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.domain.Account;
import wine.domain.Authorities;
import wine.repositories.AccountRepository;
import wine.repositories.AuthorityRepository;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController implements ControllerInterface {
	
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthorityRepository authorityRepo;

	@GetMapping
	public String login(Model model) {
		try {
			accountRepo.save(new Account("Onne", passwordEncoder.encode("Hello")));
			authorityRepo.save(new Authorities(accountRepo.findByUsername("Onne").getId(), "Onne"));
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		model.addAttribute("account", new Account());
		return "login";
	}

	@PostMapping
	public String processDesign(@ModelAttribute Account account, Errors errors) {
		if (errors.hasErrors()) {
			return "login";
		}
		return "redirect:/home";
	}
}