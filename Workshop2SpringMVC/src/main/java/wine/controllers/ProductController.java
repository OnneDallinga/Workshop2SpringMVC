package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wine.services.ProductService;

@Controller
public class ProductController implements ControllerInterface {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String getProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/products/show/{id}")
    public String showProductById(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.getProductById(Long.valueOf(id)));

        return "products/show";
    }
}
