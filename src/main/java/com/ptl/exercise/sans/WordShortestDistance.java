package com.ptl.exercise.sans;

public class WordShortestDistance {
 
    public static double shortestDistance(String document, String word1, String word2){

        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        String[] words = document.split("\\s");  // Split by space

        int index = 0;
        double shortest = document.length();
        double word1Loc = -1;
        double word2Loc = -1;
    
        for (String word : words) {
            if (word.startsWith(word1)) {
                word1Loc = index + (word.length() / 2.0);
                char lastChar = word.charAt(word.length() - 1);
                if(lastChar < 'a' || lastChar > 'z'){
                    word1Loc -= 1 / 2.0;
                }
            } else if (word.startsWith(word2)) {
                word2Loc = index + (word.length() / 2.0);
                char lastChar = word.charAt(word.length() - 1);
                if(lastChar < 'a' || lastChar > 'z'){
                    word1Loc += 1 / 2.0;
                }
            }
    
            if (word1Loc >= 0 && word2Loc >= 0) {
                double current = Math.abs(word2Loc - word1Loc);
                if (current < shortest) {
                    shortest = current;
                }
            }
    
            index += word.length() + 1;  // Account for space after each word
        }
    
        if (word1Loc == -1 || word2Loc == -1) {
            return -1;  // Return -1 if either word is not found
        }
    
        return shortest;
    }
    
    public static void main(String[] args) {
        String document = 
            "It is a long established fact that a reader will be distracted by the readable " + 
            "content of a page when looking at its layout. The point of using Lorem Ipsum is " + 
            "that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, " + 
            "content here', making it look like readable English. Many desktop publishing packages and " + 
            "web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will " + 
            "uncover many web sites still in their infancy. Various versions have evolved over the years, " +
            "sometimes by accident, sometimes on purpose (injected humour and the like)." ;

        System.out.println(shortestDistance(document, "layout", "The") == 6.5d);    
        System.out.println(shortestDistance(document, "will", "distracted") == 11d);  
        System.out.println(shortestDistance(document, "using", "here") == 14.5d);  
        System.out.println(shortestDistance(document, "using", "Content"));  
    }
}
