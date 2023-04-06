package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.Entities.Order;
import com.project.database.Entities.user.User;
import com.project.database.Repository.OrderRepository;
import com.project.database.Repository.user.UserRepositery;

@Service
public class OrderService {

    private final OrderRepository orderDao;
    private final UserRepositery userRepositery;


    @Autowired
    public OrderService(OrderRepository orderDao,UserRepositery userRepositery) {
        this.orderDao = orderDao;
        this.userRepositery=userRepositery;
    }
    public List<Order>FindAll(){
        return orderDao.findAll();
    }
    public Optional<Order> FindById(int id){
        return orderDao.findById(id);
    }

    public Order insert (Order order){
        return orderDao.save(order);
    }
    public void delete(int id){
        orderDao.deleteById(id);
    }
    // public List<Order> getOrders(User user) {
    //     return orderDao.findByUser(user);
    //   }

    public List<Order> findByUserr(int userId){

        Optional <User> user= this.userRepositery.findById(userId);
        return  this.orderDao.findByUser(user);
      }
    

}
