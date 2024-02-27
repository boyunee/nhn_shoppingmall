package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {
    /*Table: products
    Columns:
    product_id int AI PK
    category_id int
    model_number varchar(10)
    model_name varchar(120)
    product_image varchar(30)
    unit_cost decimal(15,0)
    Description text*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;

    private String Description;

}