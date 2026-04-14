package com.ecom.ecom02.config;

import com.ecom.ecom02.entity.Category;
import com.ecom.ecom02.entity.Product;
import com.ecom.ecom02.repository.CategoryRepository;
import com.ecom.ecom02.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        // Categories
        Category electronics = new Category(null, "Electronics", "Electronic devices and gadgets", null);
        Category clothing = new Category(null, "Clothing", "Apparel and accessories", null);
        Category books = new Category(null, "Books", "Books and educational materials", null);

        categoryRepository.save(electronics);
        categoryRepository.save(clothing);
        categoryRepository.save(books);

        // Products
        productRepository.save(new Product(null, "Laptop Pro 15", "High-performance laptop", new BigDecimal("1299.99"), 50, electronics));
        productRepository.save(new Product(null, "Wireless Mouse", "Ergonomic wireless mouse", new BigDecimal("29.99"), 200, electronics));
        productRepository.save(new Product(null, "USB-C Hub", "7-in-1 USB-C hub", new BigDecimal("49.99"), 150, electronics));
        productRepository.save(new Product(null, "Running Shoes", "Lightweight running shoes", new BigDecimal("89.99"), 100, clothing));
        productRepository.save(new Product(null, "Denim Jacket", "Classic denim jacket", new BigDecimal("59.99"), 75, clothing));
        productRepository.save(new Product(null, "Spring Boot in Action", "Comprehensive Spring Boot guide", new BigDecimal("39.99"), 300, books));
        productRepository.save(new Product(null, "Clean Code", "A Handbook of Agile Software Craftsmanship", new BigDecimal("34.99"), 250, books));

        System.out.println(">>> Sample data initialized successfully!");
    }
}
