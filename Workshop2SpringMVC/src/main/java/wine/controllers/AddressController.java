package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import wine.domain.Address;
import wine.services.AddressService;

@Controller
public class AddressController implements ControllerInterface {
    
    private final AddressService addressService;
    
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/{id}/show")
    public String showAddressById(@PathVariable Long id, Model model) {
        model.addAttribute("address", addressService.findAddressById(id));
        return "address/show";
    }

    @GetMapping("/address/new")
    public String newAddress(@ModelAttribute Address address) {
        return "address/addressform";
    }

    @GetMapping("address/{id}/edit")
    public String updateAddress(@PathVariable Long id, Model model) {
        model.addAttribute("address", addressService.findAddressById(id));
        return "address/addressform";
    }

    @PostMapping("address")
    public String saveWine(@ModelAttribute Address address) {
        addressService.save(address);
        return "redirect:/address/" + address.getId() + "/show";
    }

    @GetMapping("/address/{id}/delete")
    public String deleteAddressById(@PathVariable Long id) {
        addressService.deleteById(id);
        return "redirect:/customers/all";
    }
    
}
