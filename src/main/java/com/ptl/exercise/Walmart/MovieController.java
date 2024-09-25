package com.ptl.exercise.Walmart;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    public static void main(String[] args) {
        String s = "This. is a word";
        String[] arr = s.split("[,\\.\\s]+");
        System.out.println(Arrays.toString(arr));
    }
    
}
