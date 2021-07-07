package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

@NoArgsConstructor
@AllArgsConstructor
public class ProductManager {
    private ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }
}