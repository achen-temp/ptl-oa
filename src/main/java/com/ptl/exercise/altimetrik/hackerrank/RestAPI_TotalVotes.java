package com.ptl.exercise.altimetrik.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RestAPI_TotalVotes {

    public static void main(String[] args) {
        String cityName = "Seattle";
        int estimated_cost = 110;
        System.out.println(getVoteCount(cityName, estimated_cost));
    }
    
    //DO NOT USE COPY PASTE
    public static int getVoteCount(String cityName, int estimatedCost){
        try {
      
            String urlString = String.format(
                "https://jsonmock.hackerrank.com/api/food_outlets?city=%s&estimated_cost=%d",
                cityName, estimatedCost);
            URL url = new URL(urlString);

            // Create HTTP connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(content.toString());

            // Check if there are any data records
            JSONArray data = (JSONArray) jsonResponse.get("data");
            if (data.isEmpty()) {
                return -1;
            }

            // Sum the votes for all matching outlets
            int totalVotes = 0;
            for (Object obj : data) {
                JSONObject outlet = (JSONObject) obj;
                JSONObject userRating = (JSONObject) outlet.get("user_rating");
                long votes = (long) userRating.get("votes");
                totalVotes += votes;
            }

            return totalVotes;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }


    }
}
