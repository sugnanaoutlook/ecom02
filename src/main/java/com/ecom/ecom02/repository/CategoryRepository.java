package com.ecom.ecom02.repository;

import com.ecom.ecom02.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
