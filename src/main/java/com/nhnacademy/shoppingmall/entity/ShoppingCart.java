package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shopping_cart")
public class ShoppingCart {
    /*Table: shopping_cart
    Columns:
    record_id int AI PK
    cart_id varchar(150)
    quantity int
    product_id int
    date_created datetime*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "cart_id")
    private String cartId;

    private Integer quantity;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;



}
