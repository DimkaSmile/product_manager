
package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
//import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book coreJava = new Book();
    private final Smartphone coreJava1 = new Smartphone();
    //private final Product product = new Product();
    private final Smartphone galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private final Book petCemetery = new Book(4, "PetCemetery", 350, "StephenKing");
    private final Product coffee = new Product(9, "С1", 50);

    @Test
    public void shouldSaveOneProduct() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        repository.save(galaxy);
        repository.save(petCemetery);
        repository.save(coffee);

        Product[] expected = {galaxy, petCemetery, coffee};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        //int idToRemove = 9;
        repository.save(galaxy);
        repository.save(petCemetery);
        repository.save(coffee);

        repository.removeById(9);

        Product[] actual = repository.findAll();
        Product[] expected = {galaxy, petCemetery};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById2() {
        repository.save(galaxy);
        repository.save(petCemetery);
        repository.save(coffee);

        repository.removeById(1);
        repository.removeById(4);
        repository.removeById(9);

        Product[] actual = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        repository.save(galaxy);
        repository.save(petCemetery);
        repository.save(coffee);

        Product[] actual = repository.findAll();
        Product[] expected = {galaxy, petCemetery, coffee};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2() {
        repository.save(galaxy);

        Product[] actual = repository.findAll();
        Product[] expected = {galaxy};

        assertArrayEquals(expected, actual);
    }
}