package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllProductsByCategoryId(int id);

    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE "
            + "(:categoryId IS NULL OR p.category.id = :categoryId) AND "
            + "(:minPrice IS NULL OR p.price >= :minPrice) AND "
            + "(:maxPrice IS NULL OR p.price <= :maxPrice) AND "
            + "(:inStock IS NULL OR p.stock > 0)")
    List<Product> filterProducts(
            @Param("categoryId") Integer categoryId,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("inStock") Boolean inStock);
}
