package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wine.domain.Product;
import wine.services.ProductService;

@Controller
public class ProductController implements ControllerInterface {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }

    @GetMapping("/products/{id}/show")
    public String showProductById(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/show";
    }

    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute Product product) {
        return "products/productform";
    }

    @GetMapping("/products/{id}/edit")
    public String updateProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/productform";
    }

    @PostMapping("product")
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/" + product.getId() + "/show";
    }

    @GetMapping("products/{id}/delete")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
