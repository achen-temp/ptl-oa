package com.ptl.exercise.koriHackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

public class RestAPI_GetAuthorArticles {

    public static void main(String[] args) {
        List<String> result = getArticleTitles("epaga");
        System.out.println(result);
    }

    public static final String URL = "https://jsonmock.hackerrank.com/api/articles?author=";

    public static List<String> getArticleTitles(String author){
        int page = 1;
        long totalPage = 1L;
        String response;

        List<String> result = new ArrayList<>();
        try {
            while (page <= totalPage) {
                author = author.replace(" ", "%20");
                URL obj = new URL(URL + author + "&page=" + page);

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
                        Object titleObject = dataJson.get("title");
                        if(titleObject != null){
                            String title = (String)titleObject;
                            result.add(title);
                        }else {
                            Object storyTitleObject = dataJson.get("story_title");
                            if (storyTitleObject != null) {
                                String storyTitle = (String) storyTitleObject;
                                result.add(storyTitle);
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

//WHEN google JSON api is not available -- use below method
/*
    public static List<String> getArticleTitles(String author){
        int page = 1;
        int totalPage = 1;
        String response;

        List<String> result = new ArrayList<>();
        try {
            while (page <= totalPage) {
                author = author.replace(" ", "%20");
                URL obj = new URL(URL + author + "&page=" + page);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                while ((response = in.readLine()) != null) {
                    int dataIndex = response.indexOf("data");
                    if(dataIndex < 0){
                        break;
                    }

                    response = response.substring(response.indexOf("data") + 8);
                    //System.out.println(response);
                    String[] dataArray = response.split("\"created_at\"");
                    for(String str : dataArray){
                        System.out.println(str);
                        int titleStart = str.indexOf("\"title\"") + "\"title\":".length();
                        int titleEnd = str.indexOf("\"url") - 1;
                        if(titleEnd <= titleStart){
                            break;
                        }
                        String title = str.substring(titleStart, titleEnd);
                        if( ! title.contains("null")){
                            result.add(title.substring(1, title.length() - 1)); //?
                        }else{
                            int storyTitleStart = str.indexOf("story_title") + "story_title".length() + 2;
                            int storyTitleEnd = str.indexOf("story_url") - 2;
                            if(storyTitleEnd <= storyTitleStart){
                                break;
                            }
                            String storyTitle = str.substring(storyTitleStart, storyTitleEnd);
                            if(!storyTitle.contains("null")){
                                result.add(storyTitle.substring(1, storyTitle.length() - 1));
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
 */
