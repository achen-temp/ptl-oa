package com.ptl.exercise.Walmart;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * https://jsonmock.hackerrank.com/api/movies/search/?Title=waterworld
 * 
 * GIVEN Above URL.  Write a MVC with rest api to fetch this URL and then create a new rest api
 * that can fetch a particular movie based on its imdbID.
 */
/**
 * Solutions
 * 1. look at this URL date, it has multiple pages, each page has 10 movies, we need to fetch all pages
 * to get a full list of movies and then filter to find the particular movie by imdbID
 * 2. each movie has Title, Year, imdbID three fields, we need to create a model to match them
 * 3. need org.json.simple to parse the json object from the given URL.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    private MovieService service;

    @GetMapping("/{imdbID}")
    public Movie getMovieByImdbID(@PathVariable("imdbID") String imdbID){
        return service.getMovieByImdbID(imdbID);
    }
}

@Service
class MovieService{

    public static final String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=waterworld";

    public List<Movie> getAllMovies(){
        RestTemplate restTemplate = new RestTemplate();
        List<Movie> movies = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        long totalPages = 1;
        
        //use a for loop to fetch all pages data
        for(int page = 1; page <= totalPages; page++){
            String pageUrl = URL + "&page=" + page; //add page
            String response = restTemplate.getForObject(pageUrl, String.class);

            try{
                JSONObject jsonObject = (JSONObject)jsonParser.parse(response);
                if(totalPages == 1){
                    totalPages = (Long)jsonObject.get("total_pages");
                }

                JSONArray jsonArray = (JSONArray)jsonObject.get("data");
                for(Object obj : jsonArray){
                    Movie movie = new Movie((JSONObject)obj);
                    movies.add(movie);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return movies;
    }


    public Movie getMovieByImdbID(String imdbId){
        List<Movie> movies = this.getAllMovies();
        return movies.stream().filter(m -> imdbId.equalsIgnoreCase(m.getImdbID())).findFirst().orElse(null);
    } 
}

//this is the model class, can be in separate package
class Movie{

    String title;
    Long year;
    String imdbID;

    //set fields based on the json parsed in
    public Movie(JSONObject json) {
        setTitle((String)json.get("Title"));
        setYear((Long)json.get("Year"));
        setImdbID((String)json.get("imdbID"));
    }

    //all getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getYear() {
        return year;
    }
    public void setYear(Long year) {
        this.year = year;
    }
    public String getImdbID() {
        return imdbID;
    }
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    
}
