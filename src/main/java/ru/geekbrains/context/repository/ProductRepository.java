package ru.geekbrains.context.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import ru.geekbrains.context.Product;

@Component
public interface ProductRepository {
    Product findById(Long id);

    List<Product> findAll();
}