package ru.geekbrains.spring.springone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.springone.model.Product;
import ru.geekbrains.spring.springone.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "/products";
    }

    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = Optional.ofNullable(productService.getProductById(id));
        product.ifPresent(value -> model.addAttribute("product", value));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreator() {
        return "create_product_form";
    }

    @PostMapping("/create")
    public String createNewStudent(@RequestParam Long id, @RequestParam int cost, @RequestParam String name) {
        Product product = new Product(id, cost, name);
        productService.addProduct(product);
        return "redirect:/products/getAll";
    }
}
