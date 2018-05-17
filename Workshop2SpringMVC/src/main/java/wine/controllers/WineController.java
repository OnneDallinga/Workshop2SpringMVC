package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wine.domain.Wine;
import wine.services.WineService;

@Controller
@RequestMapping("/products/wines")
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/all")
    public String listWines(Model model) {
        model.addAttribute("wines", wineService.findAllWines());
        return "products";
    }

    @GetMapping("/{id}/show")
    public String showWineById(@PathVariable Long id, Model model) {
        model.addAttribute("wine", wineService.findWineById(id));
        return "wines/show";
    }

    @GetMapping("/new")
    public String newWine(@ModelAttribute Wine wine) {
        return "wines/wineform";
    }

    @GetMapping("/{id}/edit")
    public String updateWine(@PathVariable Long id, Model model) {
        model.addAttribute("wine", wineService.findWineById(id));
        return "wines/wineform";
    }

    @PostMapping("wine")
    public String saveWine(@ModelAttribute Wine wine) {
        wineService.save(wine);
        return "redirect:/" + wine.getId() + "/show";
    }

    @GetMapping("/{id}/delete")
    public String deleteWineById(@PathVariable Long id) {
        wineService.deleteById(id);
        return "redirect:/";
    }

}
