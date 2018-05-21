package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wine.domain.Wine;
import wine.services.WineService;

@Controller
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/products/wines/all")
    public String listWines(Model model) {
        model.addAttribute("wines", wineService.findAllWines());
        return "products/wines/wines";
    }

    @GetMapping("/products/wines/{id}/show")
    public String showWineById(@PathVariable Long id, Model model) {
        model.addAttribute("wine", wineService.findWineById(id));
        return "products/wines/show";
    }

    @GetMapping("/products/wines/new")
    public String newWine(@ModelAttribute Wine wine) {
        return "products/wines/wineform";
    }

    @GetMapping("products/wines/{id}/edit")
    public String updateWine(@PathVariable Long id, Model model) {
        model.addAttribute("wine", wineService.findWineById(id));
        return "products/wines/wineform";
    }

    @PostMapping("wine")
    public String saveWine(@ModelAttribute Wine wine) {
        wineService.save(wine);
        return "redirect:/products/wines/" + wine.getId() + "/show";
    }

    @GetMapping("/products/wines/{id}/delete")
    public String deleteWineById(@PathVariable Long id) {
        wineService.deleteById(id);
        return "redirect:/products/wines/all";
    }

}
