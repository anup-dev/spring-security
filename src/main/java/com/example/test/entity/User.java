package com.example.test.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.cfg.ImprovedNamingStrategy;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Anup on 9/9/15.
 */
@Getter
@Setter
@Entity
public class User{

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String email;
    private String password;
    private String role;

    public User(User u) {
        this.userName = u.getUserName();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.role = u.getRole();
    }

    public User() {
    }
}
