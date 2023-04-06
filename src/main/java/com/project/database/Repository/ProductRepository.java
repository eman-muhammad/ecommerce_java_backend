package com.project.database.Repository;

import com.project.database.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where category_id=1", nativeQuery = true)
    public List<Product> FindProductByCategoryWomen();

    @Query(value = "select * from product where category_id=2", nativeQuery = true)
    public List<Product> FindProductByCategoryMen();
}
