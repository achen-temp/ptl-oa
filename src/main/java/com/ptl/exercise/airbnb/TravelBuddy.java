package com.ptl.exercise.airbnb;
import java.util.*;
import java.util.stream.IntStream;

public class TravelBuddy {

    public static void main(String[] args) {
        String[] buddies = {
                "U1,Shanghai,NewYork,Paris,Dallas",
                "U2,Chicago,London,Paris,Dallas",
                "U3,Rio,London,Philly",
                "U4,Brunswick,NewHope,Princeton,Paris",
                "U5,Shanghai,NewYork,Paris,Dallas",
        };
        System.out.println(recommendBuddies(buddies, "U1"));
    }

    public static List<String> recommendBuddies(String[] buddies, String username){
        Map<String, List<String>> map = new HashMap<>();
        for(String buddy : buddies){
            String[] items = buddy.split(",");
            map.put(items[0], new ArrayList<>());
            IntStream.range(0, items.length).filter(i -> i != 0).forEach(i -> map.get(items[0]).add(items[i]));
        }
        map.keySet().forEach(key -> System.out.println(key + ":" + map.get(key)));
        Queue<BuddyScore> queue = new PriorityQueue<>((b1,b2) -> Double.compare(b2.score, b1.score));
        for(String user : map.keySet()){
            if(user.equalsIgnoreCase(username)){
                continue;
            }
            double score = getBuddyScore(map.get(username), map.get(user));
            queue.add(new BuddyScore(user, score));
            System.out.println(user + " : score : " + score);
        }
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll().name);
        }
        return result;
    }

    public static double getBuddyScore(List<String> list1, List<String> list2){
        int match = 0;
        for(String s : list1){
            match += list2.contains(s) ? 1 : 0;
        }
        return match * 1.0 / list1.size();
    }

}

class BuddyScore{
    String name;
    Double score;

    public BuddyScore(String name, Double score) {
        this.name = name;
        this.score = score;
    }
}

class User{
    String name;
    String password;

    public User(String  name, String  passwrd){
        this.name = name;
        this.password = passwrd;
    }

    public static void main(String[] args) {
        User user = new User("Jack", generatePawword());
        System.out.println("User is " + user.name + " and password is " + user.password);
    }
    private static String generatePawword(){
        String characters = "AB";
        Integer characterLength = characters.length();
        String password = "";
        Random random = new Random();
        for(int i = 0; i <= 5; i++){
            System.out.println(password);
            password += characters.charAt(random.nextInt());
        }
        return password;
    }
}
