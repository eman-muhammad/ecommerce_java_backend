package com.project.database.Entities;

import java.util.ArrayList;
import java.util.List;

import com.project.database.Entities.user.User;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private int total;
    private String name;
    private String address;
    private String phone;


   @ManyToOne()
   @JoinColumn(name="user_id")
   private User user;



// @ManyToMany()
// @JoinTable(name = "order_has_product",joinColumns=@JoinColumn(name = "order_id"),
// inverseJoinColumns = @JoinColumn(name="product_id" ) )
//      private List<Product> products;

@OneToMany(mappedBy = "order")
  private List<OrderHasProduct> quantities;
}
