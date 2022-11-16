package com.ptl.exercise.Redolent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RestAPI_CountryCodes {

    public static void main(String[] args) {
        String country = "Afghanistan";
        String phoneNumber = "656445445";
        String result = getPhoneNumbers(country, phoneNumber);
        System.out.println(result);
    }

    public static final String URL = "https://jsonmock.hackerrank.com/api/countries?name=";

    public static String getPhoneNumbers(String country, String phoneNumber) {
        int page = 1;
        int totalPage = 1;
        String response;

        String result = "-1";
        try {
            while (page <= totalPage) {
                country = country.replace(" ", "%20");
                URL obj = new URL(URL + country + "&page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    //System.out.print(response);
                    //"callingCodes": ["21","32"]
                    int callingCodesIndex = response.indexOf("callingCodes");
                    if (callingCodesIndex <= 0) {
                        break;
                    }
                    System.out.println(response.charAt(callingCodesIndex));
                    int startIndex = response.indexOf("[", callingCodesIndex); // first [ after "callingCodes"
                    int endIndex = response.indexOf("]", callingCodesIndex);// first ] after "callingCodes"
                    String arr = response.substring(startIndex + 1, endIndex);
                    //System.out.println(arr);
                    String[] codeArr = arr.split("\""); //split by ";
                    String code = codeArr[codeArr.length - 1];
                    result = "+" + code + " " + phoneNumber;
                }
                page++;
            }
        } catch (IOException e) {
            return result;
        }
        return result;
    }
}
