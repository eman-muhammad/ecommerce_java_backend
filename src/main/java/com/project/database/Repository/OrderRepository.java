package com.project.database.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.database.Entities.Order;
import com.project.database.Entities.user.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>  {

  //  List<Order> findByUser(User user);

  //@Query(value = "select * from orders where user_id=:id",nativeQuery=true)
  List<Order> findByUser(Optional<User> optional);
  

  

}
