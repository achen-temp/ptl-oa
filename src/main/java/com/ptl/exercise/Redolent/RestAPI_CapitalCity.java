package com.ptl.exercise.Redolent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class RestAPI_CapitalCity {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Afghanistan");
        for (String country : countries) {
            String result = getCapitalCity(country);
            System.out.println(result);
        }
    }

    public static final String URL = "https://jsonmock.hackerrank.com/api/countries?name=";

    public static String getCapitalCity(String country) {
        int page = 1;
        int totalPage = 1;
        String response;

        String result = "-1";
        try {
            while (page <= totalPage) {
                country = country.replace(" ", "%20");
                java.net.URL obj = new URL(URL + country + "&page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    //System.out.print(response);
                    //"callingCodes": ["21","32"]
                    int callingCodesIndex = response.indexOf("capital");
                    if (callingCodesIndex <= 0) { //empty
                        break;
                    }
                    int startIndex = response.indexOf(":\"", callingCodesIndex); // first " after "callingCodes"
                    int endIndex = response.indexOf("\"", startIndex + 2);// first ] after "callingCodes"
                    result = response.substring(startIndex + 2, endIndex);
                }
                page++;
            }
        } catch (IOException e) {
            return "-1";
        }
        return (result == null || result.trim().length() == 0) ? "-1" : result;
    }
}
