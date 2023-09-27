package com.ptl.exercise.Redolent;

import org.json.simple.JSONArray; //must have
import org.json.simple.JSONObject; //must have
import org.json.simple.parser.JSONParser; //must have
import org.json.simple.parser.ParseException; //must have

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RestAPI_CountryCodes {

    public static void main(String[] args) {
        String country = "Japan"; //Afghanistan
        String phoneNumber = "656445445";
        String result = getPhoneNumbers(country, phoneNumber);
        System.out.println(result);
    }

    //PUT this on top of the method
    public static final String URL = "https://jsonmock.hackerrank.com/api/countries?name=";

    //USE THIS METHOD - remember to import the 4 org.json.simple dependencies
    public static String getPhoneNumbers(String country, String phoneNumber) {
        int page = 1;
        long totalPage = 1;
        String response;

        String result = "-1";
        try {
            while (page <= totalPage) {
                country = country.replace(" ", "%20"); //There is a space between " "
                URL obj = new URL(URL + country + "&page=" + page);

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
                        Object callingCodesArr = dataJson.get("callingCodes");
                        if(callingCodesArr != null){
                            JSONArray callingCodes = (JSONArray)callingCodesArr;
                            String callingCode = (String)callingCodes.get(callingCodes.size() - 1);
                            if(callingCode != null && callingCode.length() > 0){
                                result = "+" + callingCode + " " + phoneNumber;
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

    public static String getPhoneNumbers_BAK(String country, String phoneNumber) {
        int page = 1;
        int totalPage = 1;
        String response;

        String result = "-1";
        try {
            while (page <= totalPage) {
                country = country.replace(" ", "%20"); //There is a space between " "
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
