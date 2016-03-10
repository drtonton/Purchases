package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by noellemachin on 3/9/16.
 */
@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init() throws FileNotFoundException {
        readCustomers(); //reads customers.csv into table
        readPurchases(); //reads purchases.csv into table
    }

    public void readCustomers () throws FileNotFoundException {
        File f = new File("customers.csv");  // f equals customers.csv
        Scanner fileScan = new Scanner(f);  // fileScan scans "f"
        fileScan.nextLine();  // skip a line
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            String [] columns = line.split(",");
            Customer customer = new Customer(columns[0], columns[1]);
            customers.save(customer);  // saving new customer object into the db table
        }
    }
    public void readPurchases() throws FileNotFoundException {
        File f = new File("purchases.csv");
        Scanner fileScan = new Scanner(f);
        fileScan.nextLine();
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            String [] columns = line.split(",");
            Purchase purchase = new Purchase(columns[1], columns[2], columns[3], columns[4]);
            purchases.save(purchase);
        }
    }
}
