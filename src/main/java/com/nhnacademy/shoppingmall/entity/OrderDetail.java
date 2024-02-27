package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.rmi.UnmarshalException;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_details")
public class OrderDetail {
    /*Table: order_details
    Columns:
    order_id int PK
    product_id int PK
    quantity int
    unit_cost decimal(15,0)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;

    private Integer qauntity;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;
}
