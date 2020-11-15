package com.sungsu.dev.app.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sungsu.dev.app.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
