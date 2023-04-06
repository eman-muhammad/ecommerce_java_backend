package com.project.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.Entities.Order;
import com.project.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping
    public List<Order>FindAll(){
        return orderService.FindAll();
    }
    @GetMapping("/{id}")
    public Optional <Order>FindById(@PathVariable int id){
        return orderService.FindById(id);
    }


    @PostMapping
    public Order insert(@RequestBody Order order ){
        return orderService.insert(order);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }

//     @GetMapping
//      public List<Order> getOrders(Useruser) {
//     return orderService.getOrders(user);
//   }

@GetMapping("/user/{userId}")
    public List<Order> findByUser(@PathVariable int userId){
        return  this.orderService.findByUserr(userId);
  
  
  
      }
}
