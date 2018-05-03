package wine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import wine.utility.ControllerInterface;

@Slf4j
@Controller
public class HomeController implements ControllerInterface {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}