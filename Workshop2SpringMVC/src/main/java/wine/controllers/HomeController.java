package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController implements ControllerInterface {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}