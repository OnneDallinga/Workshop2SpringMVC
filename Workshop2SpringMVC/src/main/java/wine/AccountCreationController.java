package wine;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.account.Account;
import wine.utility.ControllerInterface;

@Slf4j
@Controller
@RequestMapping("/register")
public class AccountCreationController implements ControllerInterface {
	
	@GetMapping
	public String showAccountEssentials(Model model) {
		model.addAttribute("username");
		model.addAttribute("password");
		model.addAttribute("account", new Account());
		return "register";
	}
	
	@PostMapping
	public String processNewAccount(@Valid Account account, Errors errors) {
		if (errors.hasErrors()) {
			return "account";
		}

		return "redirect:/";
	}
}
