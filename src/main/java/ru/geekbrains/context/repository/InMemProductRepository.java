package ru.geekbrains.context.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.geekbrains.context.Product;

@Component
@Primary
public class InMemProductRepository implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread"),
                new Product(2L, "Milk"),
                new Product(3L, "Apples"),
                new Product(4L, "Car"),
                new Product(5L, "Motorcycle")
        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}