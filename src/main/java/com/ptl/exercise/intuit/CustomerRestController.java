package com.ptl.exercise.intuit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Customer API endpoints are here
 *
 *  We need to
 *  1. Create a customer:
 *      In order to create a customer:
 *          - One phone number of any types is required
 *          - One shipping address and One billing address is required.
 *          - A customer, in his life time can't have more than 1 billing address and 1 shipping address.
 *  2. Retrieve a customer given customer ID
 *  3. Update a customer
 *  4. Delete a customer
 *
 *  --> After designing the API end point, please implement 1, and write definition for 2, 3, 4
 *  --> You can design the api using open api specs or plain text and json
 */
/**
 CustomDTO{
    "phone" : [
            {
                "phoneType" : "",
                "phoneNumber" : ""
            },
            {
                "phoneType" : "",
                "phoneNumber" : ""
            }


 ],
 "addresses" : [
     {
     "addressType" : "",
     "addressLine1" : "",
     "addressLine2" : "",
     "city":"",
     "state:"",
     "zip":":
    }
 ]


 */

public class CustomerRestController {


}
