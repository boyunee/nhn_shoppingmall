package com.nhnacademy.shoppingmall.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/*Table: users
Columns:
user_id varchar(50) PK
user_name varchar(50)
user_password varchar(200)
user_birth varchar(8)
user_auth varchar(10)
user_point int
created_at datetime
latest_login_at datetime*/
@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_birth")
    private String userBirth;

    @Column(name = "user_auth")
    private com.nhnacademy.shoppingmall.user.domain.User.Auth userAuth;

    @Column(name = "user_point")
    private int userPoint;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "latest_login_at")
    private LocalDateTime latestLoginAt;
}
