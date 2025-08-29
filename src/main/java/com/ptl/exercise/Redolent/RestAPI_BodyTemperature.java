package com.ptl.exercise.redolent;

import org.json.simple.JSONArray; //must have
import org.json.simple.JSONObject; //must have
import org.json.simple.parser.JSONParser; //must have
import org.json.simple.parser.ParseException; //must have

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RestAPI_BodyTemperature {
    public static void main(String[] args) {
        String doctorName = "Dr Arnold Bullock";
        int diagnosisId = 2;
        List<Integer> result = bodyTemperature(doctorName, diagnosisId);
        System.out.println(result);
    }

    //this code is tested in hackerrank************

    //this is on top of the method, make sure it is HTTPS, not HTTP
    public static final String URL = "https://jsonmock.hackerrank.com/api/medical_records";

    //USE THIS ONE -- make sure you have the org.json.simple.... imports
    public static List<Integer> bodyTemperature(String doctorName, int diagnosisId) {
        long page = 1;
        long totalPage = 1;
        String response;

        List<Integer> result = new ArrayList<>();
        Double minTemperature = Double.MAX_VALUE;
        Double maxTemperature = Double.MIN_VALUE;
        try {
            while (page <= totalPage) {
                java.net.URL obj = new URL(URL + "?page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    JSONParser parser = new JSONParser();
                    JSONObject responseObject = (JSONObject) parser.parse(response);

                    totalPage = (long)responseObject.get("total_pages");
                    JSONArray dataArray = (JSONArray) responseObject.get("data");
                    if(dataArray == null || dataArray.size() == 0){
                        break;
                    }

                    for(Object dataObj : dataArray){
                        JSONObject dataJson = (JSONObject) dataObj;
                        JSONObject doctorJson = (JSONObject)dataJson.get("doctor");
                        String doctor = (String)doctorJson.get("name");
                        JSONObject diagnosisJson = (JSONObject)dataJson.get("diagnosis");
                        Long id = (Long)diagnosisJson.get("id");
                        if(doctorName.equals(doctor) && diagnosisId == id.intValue()){
                            JSONObject vitalsJson = (JSONObject)dataJson.get("vitals");
                            Object tempObject = vitalsJson.get("bodyTemperature");
                            Double bodyTemperature = 0.0;
                            if(tempObject instanceof Long){
                                bodyTemperature = 1.0 * (Long)tempObject;
                            }else if(tempObject instanceof Double){
                                bodyTemperature = (Double)tempObject;
                            }
                            if(bodyTemperature < minTemperature){
                                minTemperature = bodyTemperature;
                            }
                            if(bodyTemperature > maxTemperature){
                                maxTemperature = bodyTemperature;
                            }
                        }
                    }
                }
                page++;
            }
        } catch (IOException | ParseException e) {
            return result;
        }
        result.add((int) Math.floor(minTemperature));
        result.add((int) Math.floor(maxTemperature));
        return result;
    }
}

