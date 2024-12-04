package com.ptl.exercise.enfec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class oa {

    /**
     * 1. given an integer array, find the 2nd largest number in this array
     */


    /**
     * 2. given URL: https://jsonplaceholder.typicode.com/users
     * You need to write a REST api to call the given URL and return a user with its "name, email, zipcode"
     * for example, if user id is 1, you should return a JSON file with username "Bret", email "Sincere@april.biz" and zipcode "92998-3874"
     * HINT: use "Rest Template"
     *
     * Result: OPEN a webbrowser and enter: http://localhost:8080/user/1  should return the correct result.
     */

     /**
      * Coding: Given a string, return characters with min and max count
      * hello word,   min = [h, e, w, r, d], max = [l, o]
      */

    /**
     * 3. Difference between thread Wait and Sleep
     * 4. Difference between Enumeration and Iterator
     * 5. Have you done migration to microservice, how do you do it and What is the challenge in migration to microservice
     * 6. What is controller, service, repository and their orders in the application (order when a request comes)
     * 7. What is lambda expression and given me one example about it
     * 8. Tell me what do you know about authorization and authentication? (how do you do security)
     * 9. What is the AWS cloud experience do you have?
     * 10.What are the annotations you have used in spring boot
     */

}

//for problem 2
@RestController
class UserController{

    public static final String URL = "https://jsonplaceholder.typicode.com/users";

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable int id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );
        List<User> users = responseEntity.getBody();
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setZipCode(user.getAddress().getZipCode());
        return dto;
    };

}


class UserDTO{
    int id;
    String name;
    String zipCode;

    public UserDTO(){}
    public UserDTO(int id, String name, String zipCode) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

class User{
    int id;
    String name;
    String userName;
    String email;
    Address address;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address{
    String street;
    String zipCode;
    String suite;
    String city;
    Geo geo;
    public Address(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
class Geo{
    String lat;
    String lng;
    public Geo(){}

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
