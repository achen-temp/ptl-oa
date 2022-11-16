package com.ptl.exercise.Redolent;

import java.io.*;
import java.net.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestAPI_RelevantFoodOutlets {
    public static void main(String[] args) {
        //String city = "Houston";
        List<String> cities = Arrays.asList("Denver");
        int maxCost = 50;
        for (String city : cities) {
            List<String> result = getRelevantFoodOutlets(city, maxCost);
            System.out.println(city + " ==> " + result);
        }
    }

    public static final String URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=";

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) {
        int page = 1;
        int totalPage = 1;
        String response;

        List<String> result = new ArrayList<>();
        try {
            while (page <= totalPage) {
                city = city.replace(" ", "%20");
                java.net.URL obj = new URL(URL + city + "&page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    //handle total_pages
                    int startIndex = response.indexOf("total_pages") + "total_pages".length() + 2;
                    int endIndex = response.indexOf(",", startIndex);
                    //System.out.println(startIndex + ";" + endIndex);
                    String str = response.substring(startIndex, endIndex);
                    totalPage = str != null && str.length() >= 1 ? Integer.valueOf(str) : 1;

                    //handle data
                    String[] splitResponse = response.split("city");
                    for (String entry : splitResponse) {
                        if (entry.contains("name") && entry.contains("estimated_cost")) {
                            String nameKey = "\"name\":\"";
                            String costKey = "\",\"estimated_cost\":";
                            String userKey = ",\"user_rating\":";
                            int nameStart = entry.indexOf(nameKey) + nameKey.length();
                            int nameEnd = entry.indexOf(costKey);
                            int costStart = entry.indexOf(costKey) + costKey.length();
                            int costEnd = entry.indexOf(userKey);
                            String name = entry.substring(nameStart, nameEnd);
                            String cost = entry.substring(costStart, costEnd);
                            if (Integer.valueOf(cost) <= maxCost) {
                                result.add(name);
                            }
                        }
                    }
                }
                page++;
            }
        } catch (IOException e) {
            return result;
        }
        return result;
    }
}