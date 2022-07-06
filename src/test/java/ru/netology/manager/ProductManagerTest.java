
package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
//import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final Smartphone galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private final Book petCemetery = new Book(4, "PetCemetery", 350, "StephenKing");
    private final Product coffee = new Product(9, "С1", 50);
    private final Book petCemetery2 = new Book(5, "PetCemetery", 350, "Kingsli");
    ProductManager managers = new ProductManager(repository);
    //private final Product product = new Product();

    @Test
    public void add() {
        managers.add(galaxy);
        managers.add(petCemetery);
        managers.add(coffee);

        Product[] expected = {galaxy, petCemetery, coffee};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void add2() {
        managers.add(petCemetery);
        managers.add(coffee);

        Product[] expected = {petCemetery, coffee};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchBy() {
        managers.add(galaxy);

        Product[] actual = managers.searchBy("SamsungGalaxyS");
        Product[] expected = new Product[]{galaxy};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByPetCemetery() {
        managers.add(petCemetery);

        Product[] expected = new Product[]{petCemetery};
        Product[] actual = managers.searchBy("PetCemetery");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByCoffeePetCemetery() {
        managers.add(coffee);

        Product[] expected = new Product[]{coffee};
        Product[] actual = managers.searchBy("С1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorPetCemetery() {

        Product[] expected = new Product[]{};
        Product[] actual = managers.searchBy("StephenKing");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorPetCemetery2() {
        managers.add(petCemetery);
        managers.add(petCemetery2);

        Product[] actual = managers.searchBy("PetCemetery");
        Product[] expected = new Product[]{petCemetery, petCemetery2};
        assertArrayEquals(expected, actual);
    }
}