package com.ecom.ecom02.config;

import com.ecom.ecom02.entity.Category;
import com.ecom.ecom02.entity.Product;
import com.ecom.ecom02.repository.CategoryRepository;
import com.ecom.ecom02.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataInitializer(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        Category electronics = new Category();
        electronics.setName("Electronics");
        electronics.setDescription("Electronic devices and gadgets");
        categoryRepository.save(electronics);

        Category clothing = new Category();
        clothing.setName("Clothing");
        clothing.setDescription("Apparel and accessories");
        categoryRepository.save(clothing);

        Category books = new Category();
        books.setName("Books");
        books.setDescription("Books and educational materials");
        categoryRepository.save(books);

        saveProduct("Laptop Pro 15", "High-performance laptop", "1299.99", 50, electronics);
        saveProduct("Wireless Mouse", "Ergonomic wireless mouse", "29.99", 200, electronics);
        saveProduct("USB-C Hub", "7-in-1 USB-C hub", "49.99", 150, electronics);
        saveProduct("Running Shoes", "Lightweight running shoes", "89.99", 100, clothing);
        saveProduct("Denim Jacket", "Classic denim jacket", "59.99", 75, clothing);
        saveProduct("Spring Boot in Action", "Comprehensive Spring Boot guide", "39.99", 300, books);
        saveProduct("Clean Code", "A Handbook of Agile Software Craftsmanship", "34.99", 250, books);

        System.out.println(">>> Sample data initialized successfully!");
    }

    private void saveProduct(String name, String desc, String price, int stock, Category category) {
        Product p = new Product();
        p.setName(name);
        p.setDescription(desc);
        p.setPrice(new BigDecimal(price));
        p.setStock(stock);
        p.setCategory(category);
        productRepository.save(p);
    }
}
