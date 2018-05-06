package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wine.services.ProductService;

@Controller
public class ProductController implements ControllerInterface {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String getProductPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "recipes";
    }
}
