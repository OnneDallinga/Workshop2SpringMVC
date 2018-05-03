package wine;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import wine.account.Account;
import wine.utility.ControllerInterface;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController implements ControllerInterface {

	@GetMapping
	public String login() {
		return "login";
	}

	@PostMapping
	public String processDesign(@Valid Account account, Errors errors) {
		if (errors.hasErrors()) {
			return "account";
		}
		return "redirect:/mainpage";
	}
}