package com.ptl.exercise.altimetrik.hackerrank;

import org.json.simple.JSONArray; //must have
import org.json.simple.JSONObject; //must have
import org.json.simple.parser.JSONParser; //must have
import org.json.simple.parser.ParseException; //must have

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class RestAPI_FinestFoodOutlets {
    public static void main(String[] args) {
        //String city = "Houston";
        List<String> cities = Arrays.asList("Miami");
        int votes = 1000;
        for (String city : cities) {
            String result = getRelevantFoodOutlets(city, votes);
            System.out.println(city + " ==> " + result);
        }
    }

    //this is on top of the method, make sure it is HTTPS, not HTTP
    public static final String URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=";

    //USE THIS ONE -- make sure you have the org.json.simple.... imports
    public static String getRelevantFoodOutlets(String city, int votes) {
        long page = 1;
        long totalPage = 1;
        String response;

        String result = "";
        double highestRating = Double.MIN_VALUE;
        long highestVotes = Long.MIN_VALUE;

        try {
            while (page <= totalPage) {
                city = city.replace(" ", "%20"); //" " 中间有空格
                java.net.URL obj = new URL(URL + city + "&page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    JSONParser parser = new JSONParser();
                    JSONObject responseObject = (JSONObject) parser.parse(response);

                    totalPage = (long)responseObject.get("total_pages");
                    JSONArray dataArray = (JSONArray) responseObject.get("data");
                    if(dataArray == null || dataArray.size() == 0){
                        continue;
                    }

                    for(Object dataObj : dataArray){
                        JSONObject dataJson = (JSONObject) dataObj;
                        JSONObject userRating = (JSONObject)dataJson.get("user_rating");
                        Double averageRating = 0.0;
                        try{
                            averageRating = (Double)userRating.get("average_rating");
                        }catch(ClassCastException e){
                            averageRating = (Long)userRating.get("average_rating") *  1.0;
                        }
                        Long voteCounts = (Long)userRating.get("votes");
                        String name = (String) dataJson.get("name");
                        
                        if(voteCounts > votes){
                            if(averageRating > highestRating || (averageRating == highestRating && voteCounts > highestVotes)){
                                highestRating = averageRating;
                                highestVotes = voteCounts;
                                result = name;
                            }
                        }
                    }

                }
                page++;
            }
        } catch (IOException | ParseException e) {
            return result;
        }
        return result;
    }


}