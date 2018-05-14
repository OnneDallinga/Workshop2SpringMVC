package wine.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.domain.Account;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController implements ControllerInterface {

	@GetMapping
	public String login(Model model) {
		model.addAttribute("account", new Account());
		return "login";
	}

	@PostMapping
	public String processDesign(@ModelAttribute Account account) {
		if (account.getUsername().equals("Onne")) {
			return "redirect:/home";
		}
		/*if (errors.hasErrors()) {
			return "account";
		}*/
		return "redirect:/home";
	}
}