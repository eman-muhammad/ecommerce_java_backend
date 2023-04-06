package com.project.database.Repository;
import com.project.database.Entities.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderProductRepository extends JpaRepository<OrderHasProduct,Integer> {


    
}