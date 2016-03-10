package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        if (customers.count() < 1 && purchases.count() < 1) {
        readCustomers(); //reads customers.csv into table
        readPurchases(); //reads purchases.csv into table
        }
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("customers", customers.findAll());
        return "home";
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
        fileScan.close();
    }
    public void readPurchases() throws FileNotFoundException {
        File f = new File("purchases.csv");
        Scanner fileScan = new Scanner(f);
        fileScan.nextLine();
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            String [] columns = line.split(",");
            Purchase purchase = new Purchase(columns[1], columns[2], columns[3], columns[4]);
            int customerId = Integer.valueOf(columns[0]);
            purchase.customer = customers.findOne(customerId);
            purchases.save(purchase);
        }
        fileScan.close();
    }
}
