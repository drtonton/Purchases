package com.theironyard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by noellemachin on 3/9/16.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Customer() {

    }
}
