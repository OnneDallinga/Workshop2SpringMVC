package wine.controllers;

import org.springframework.http.HttpStatus;
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

    @GetMapping("/product/{id}/show")
    public String showProductById(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/show";
    }

    @GetMapping("/product/new")
    public String newProduct(@ModelAttribute Product product) {
        return "products/productform";
    }

    @GetMapping("/product/{id}/edit")
    public String updateProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/productform";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/" + product.getId() + "/show";
    }

    @GetMapping("product/{id}/delete")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
