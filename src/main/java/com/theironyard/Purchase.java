package com.theironyard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by noellemachin on 3/9/16.
 */
@Entity
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    String date;
    String creditCard;
    String cvv;
    String category;

    @ManyToOne
    Customer customer;

    public Purchase(String date, String creditCard, String cvv, String category) {
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
    }
    public Purchase () {

    }
}
