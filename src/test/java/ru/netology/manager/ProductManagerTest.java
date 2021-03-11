package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "Лукоморье", 500, "А.С.Пушкин");
    private Book second = new Book(2, "Приключение к центру Земли", 400, "М.Твен");
    private Smartphone third = new Smartphone(3, "Iphone12", 300, "Apple");
    private Smartphone forth = new Smartphone(4, "J7", 200, "Samsung");
    private Product fifth = new Product(5, "Pencil", 150);

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(forth);
        productManager.add(fifth);
    }

    @Test
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchInProduct() {
        String text = "Pencil";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookName() {
        String text = "Лукоморье";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAuthor() {
        String text = "М.Твен";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneName() {
        String text = "Iphone12";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneVendor() {
        String text = "Samsung";

        Product[] actual = productManager.searchBy(text);
        Product[] expected = new Product[]{forth};
        assertArrayEquals(expected, actual);
    }

}
