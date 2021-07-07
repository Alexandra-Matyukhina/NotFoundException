package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "name1", 350, "author1", 150, 2017);
    private Book second = new Book(2, "name2", 790, "author2", 346, 2018);
    private TShirt third = new TShirt(3, "name3", 1500, "color1", "size2");
    private TShirt forth = new TShirt(4, "name4", 799, "color2", "size4");

    @BeforeEach
    void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(forth);
    }

    @Test
    void shouldRemoveByIdIfExist() {
        int id = 1;
        repository.removeById(id);

        Product[] expected = new Product[]{second, third, forth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNotExist() {
        int id = 10;
        assertThrows(NotFoundException.class, () -> repository.removeById(id));
    }

}
