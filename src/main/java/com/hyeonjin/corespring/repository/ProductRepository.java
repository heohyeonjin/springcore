package com.hyeonjin.corespring.repository;

import com.hyeonjin.corespring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}