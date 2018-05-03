package account;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import utility.ControllerInterface;

@Controller
@RequestMapping("/register")
public class AccountCreationController implements ControllerInterface {
	
	@GetMapping("/register")
	public String showAccountEssentials(Model model) {
		model.addAttribute("username");
		model.addAttribute("password");
		model.addAttribute("account", new Account());
		return "register";
	}
	
	@PostMapping("/register")
	public String processNewAccount(@Valid Account account, Errors errors) {
		if (errors.hasErrors()) {
			return "account";
		}

		return "redirect:/";
	}
}
