package WineMain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import utility.ControllerInterface;
 

@Slf4j
@Controller
public class LoginController implements ControllerInterface {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

