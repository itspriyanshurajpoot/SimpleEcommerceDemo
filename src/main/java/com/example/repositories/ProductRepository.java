package com.example.repositories;

import com.example.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE LOWER(title) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(description) LIKE LOWER(CONCAT('%', :q, '%'))", nativeQuery = true ) // Raw SQL query
    List<Product> searchProduct(@Param("q") String q);


    @Query("SELECT p FROM Product p WHERE p.price > :minPrice")  // HQL query
    List<Product> searchProductLessThan(@Param("minPrice") double minPrice);

}
