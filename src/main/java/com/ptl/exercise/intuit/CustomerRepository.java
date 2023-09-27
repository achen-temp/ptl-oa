package com.ptl.exercise.intuit;

import java.util.UUID;

public class CustomerRepository {

    public Customer save(Customer c) {
        // Nothing to implement here.
        // just a save to save a customer

        return c;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
