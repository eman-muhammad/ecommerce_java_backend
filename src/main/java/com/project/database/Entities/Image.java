package com.project.database.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(insertable=false, updatable=false)
    private int product_id;
    private int product_category_id;

    @Lob
    private byte[] image;
    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;


    public Image(String name,  byte[] image) {
        this.name=name;
        this.image=image;
    }
}
