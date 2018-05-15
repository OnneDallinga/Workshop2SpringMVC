package wine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.domain.Account;
import wine.repositories.AccountRepository;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController implements ControllerInterface {
	
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public String login(Model model) {
		try {
			accountRepo.save(new Account("Onne", passwordEncoder.encode("Hello")));
		}
		catch (Exception e) {
			
		}
		model.addAttribute("account", new Account());
		return "login";
	}

	@PostMapping
	public String processDesign(@ModelAttribute Account account) {
		/*if (errors.hasErrors()) {
			return "account";
		}*/
		return "redirect:/home";
	}
}