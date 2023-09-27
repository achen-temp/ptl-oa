package com.ptl.exercise.intuit;

import org.springframework.lang.NonNull;

public class CustomDTO {
    private String id;
    private String name;

    public CustomDTO(String id, String name, @NonNull Address billing, @NonNull Address mailing) {
        this.id = id;
        this.name = name;
        Billing = billing;
        Mailing = mailing;
    }

    //    private Phone phone;

    @NonNull
    Address Billing;

    @NonNull
    Address Mailing;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Phone getPhone() {
//        return phone;
//    }
//
//    public void setPhone(Phone phone) {
//        this.phone = phone;
//    }

    @NonNull
    public Address getBilling() {
        return Billing;
    }

    public void setBilling(@NonNull Address billing) {
        Billing = billing;
    }

    @NonNull
    public Address getMailing() {
        return Mailing;
    }

    public void setMailing(@NonNull Address mailing) {
        Mailing = mailing;
    }
}
