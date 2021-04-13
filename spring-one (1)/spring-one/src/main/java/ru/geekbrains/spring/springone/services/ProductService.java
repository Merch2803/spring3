package ru.geekbrains.spring.springone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.springone.model.Product;
import ru.geekbrains.spring.springone.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
