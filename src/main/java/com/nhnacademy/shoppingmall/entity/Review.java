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
@Table(name = "reviews")
public class Review {
    /*Table: reviews
    Columns:
    review_id int AI PK
    product_id int
    user_id varchar(50)
    rating int
    comments text*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "user_id")
    private String userId;

    private Integer rating;

    private String comments;



}