package com.ptl.exercise.ig.magnitGlobal_angularUI;

public class ProductsSellApplication {

}

/*
 * there are 4 test cases failed because of the validation in Sell.java class
 */
/* 
@Entity
class Sell implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Product name is mandatory")   //fix 1
    private String productName; 

    @Email(message = "Invalid customer email")  //fix 2
    private String customerEmail;

    @Positive(message = "Value should be none negative") //fix 3, not negative,  non -> none
    private Integer buyingPrice;

    @Positive(message = "Value should be none negative") //fix 4 non -> none
    private Integer sellingPrice;

}
*/