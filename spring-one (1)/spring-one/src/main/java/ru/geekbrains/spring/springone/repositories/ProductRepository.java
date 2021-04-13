package ru.geekbrains.spring.springone.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.springone.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, 15, "Киви"),
                new Product(2L, 20, "Банан"),
                new Product(3L, 18, "Апельсин"),
                new Product(4L, 19, "Мандарин"),
                new Product(5L, 24, "Ананас")
        ));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new RuntimeException("Продукта с таким 'id' нет!!!");
    }

    public void addProduct(Product product) {
        long productId = product.getId();
        for (Product products : products) {
            if (productId == products.getId()) {
                throw new RuntimeException("Продукт с таким 'id' уже существует!!!");
            }
        }
        products.add(product);
    }
}
