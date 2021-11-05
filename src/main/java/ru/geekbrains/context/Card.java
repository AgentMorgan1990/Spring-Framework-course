package ru.geekbrains.context;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.geekbrains.context.repository.ProductRepository;

@Component
@Scope("prototype")
public class Card {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    private ArrayList<Product> list = new ArrayList<>();

    void showAllInCard() {
        for (Product products : list) {
            System.out.println(products.toString());
        }
    }

    void addById(Long id) {
        list.add(repository.findById(id));
    }

    void deleteById(Long id) {
        int deleteIndex = -1;
        for (Product products : list) {
            if (Objects.equals(id, products.getId())) {
                deleteIndex = list.indexOf(products);
            }
        }
        if (!(deleteIndex == -1)) {
            list.remove(deleteIndex);
        }
    }

}
