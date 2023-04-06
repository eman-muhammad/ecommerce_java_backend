package com.project.database.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String size;
    private String description;
    private int category_id;
    private String image_url;

//@Lob
//private byte[] image;
//    @OneToMany(mappedBy="product_id")
//    private Set<Image> ProductImage;

// @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "order_has_product",
//     joinColumns=@JoinColumn(name = "product_id"),
//     inverseJoinColumns = @JoinColumn(name="order_id" ) )
//,cascade={CascadeType.MERGE, CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH }
//     private List<Order> orders;


// @ManyToMany(mappedBy="products")
// private List<Order> orders;

}
