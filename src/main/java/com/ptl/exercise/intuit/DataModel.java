package com.ptl.exercise.intuit;

/**
 * DATA MODEL
 *
 * Table com.altimetrik.intrview.test.Customer : Email Address and com.altimetrik.intrview.test.Customer ID is unique
 * =========================================================
 * CustomerId   | Full Name     | email address         |
 * CUST_001     | Pratyush      | pratyush@nowhere.com  |
 * CUST_002     | John Doe      | john@nowhere.com      |
 * CUST_003     | Jane Doe      | jane@nowhere,com      |
 * =========================================================
 *
 * Table PhoneType [can be extended further]
 * =========================================================
 * HOME     | Home Address
 * WORK     | Work Address
 * MOBILE   | Mobile Phone
 * =========================================================
 *
 * Table CustomerPhone
 * =========================================================
 * CustomerId   | PhoneType     | CountryCode  |AreaCode    | Number
 * CUST_001     |HOME           |1             |510         |5478745
 * CUST_001     |WORK           |1             |510         |6453424
 * CUST_001     |MOBILE         |1             |510         |5478745
 * =========================================================
 *
 * Table AddressType [can be extended further]
 * =========================================================
 * HOME     | Home Address
 * WORK     | Work Address
 * SHIP     | Shipping Address
 * BILL     | Billing Address
 * =========================================================
 *
 * Table CustomerAddress
 * =========================================================
 * CustomerId   | AddressType   | AddressLine1  |AddressLine2   |City       | State | Zip
 * CUST_001     |HOME           |29 Kings Way   |               |Fremont    | CA    | 95413
 * CUST_001     |BILL           |29 Ocean Dr    | Suite 45      |Fremont    | CA    | 95463
 * CUST_001     |SHIP           |31 Kings Way   |               |Fremont    | CA    | 95563

 * =========================================================
 *
 */
public class DataModel {
    //EMPTY CLASS NO IMPLEMENTATION
}
