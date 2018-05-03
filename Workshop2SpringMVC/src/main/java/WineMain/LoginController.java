package WineMain;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import account.Account;
import lombok.extern.slf4j.Slf4j;
import utility.ControllerInterface;

@Slf4j
@Controller
public class LoginController implements ControllerInterface {

	@GetMapping("/login")
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