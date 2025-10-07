package com.ptl.exercise.redolent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestAPI_LongestDuration {
    public static void main(String[] args) {
        String organizer = "productize robust bandwidth";
        String genre = "Stage And Screen";
        String result = longestDuration(organizer, genre);
        System.out.println(result);
    }

    // this code is tested in hackerrank************

    // this is on top of the method, make sure it is HTTPS, not HTTP
    public static final String URL = "https://jsonmock.hackerrank.com/api/events";

    // USE THIS ONE -- make sure you have the org.json.simple.... imports
    public static String longestDuration(String organizer, String genre) {
        long page = 1;
        long totalPage = 1;
        String response;
        long maxDuration = -1;
        String result = "-1";

        try {
            while (page <= totalPage) {
                java.net.URL obj = new URL(URL + "?page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    JSONParser parser = new JSONParser();
                    JSONObject responseObject = (JSONObject) parser.parse(response);

                    totalPage = (long) responseObject.get("total_pages");
                    JSONArray dataArray = (JSONArray) responseObject.get("data");
                    if (dataArray == null || dataArray.size() == 0) {
                        break;
                    }

                    for (Object dataObj : dataArray) {
                        JSONObject dataJson = (JSONObject) dataObj;

                        String id = (String) dataJson.get("id");
                        JSONArray genresArray = (JSONArray) dataJson.get("genres");
                        long duration = (long) dataJson.get("duration");
                        String organizedBy = (String) dataJson.get("organized_by");

                        if(!organizer.equalsIgnoreCase(organizedBy.trim())){
                            continue;
                        }

                        boolean genreMatch = false;
                        for (Object genreObject : genresArray) {
                            String tempGenre = (String) genreObject;
                            //System.out.println(tempGenre);
                            if (genre.equalsIgnoreCase(tempGenre.trim())) {
                                genreMatch = true;
                                break;
                            }
                        }

                        if (genreMatch) {
                            if(duration > maxDuration){
                                maxDuration = duration;
                                result = id;
                            }else if(duration == maxDuration){
                                if(id.compareTo(result) < 0){
                                    result = id;
                                }
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
