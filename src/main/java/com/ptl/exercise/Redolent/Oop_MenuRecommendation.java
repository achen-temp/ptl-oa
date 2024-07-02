package com.ptl.exercise.Redolent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MenuItem {
    int itemId;
    String displayName;
    long sumOfRating;
    int numberOfPeopleWhoRatedId;
}

interface IMenuRecommendation {
    void addItem(int id, String displayName);
    MenuItem getRecommendedItem();
    void outOfStockItem(int itemId);
    void restockItem(int itemId);
    void makeDealOfTheDayItem(int itemId);
    void rateItem(int itemId, int rating);
}

//this code is not tested in hackerrank
//your coding starts from here ........
class MenuRecommendation implements IMenuRecommendation {
    Map<Integer, MenuItem> inStockItems = new HashMap<>();
    Map<Integer, MenuItem> outOfStockItems = new HashMap<>();
    MenuItem dealOfTheDayItem = null;

    @Override
    public void addItem(int itemId, String displayName) {
        MenuItem menuItem = new MenuItem();
        menuItem.itemId = itemId;
        menuItem.displayName = displayName;
        inStockItems.put(itemId, menuItem); // add to instock item
    }

    private int extractNumber(String s){
        String s1 = s.replaceAll("[^\\d]", "");
        return Integer.parseInt(s1);
    }

    private double getAverageRating(MenuItem item){
        return item.numberOfPeopleWhoRatedId == 0 ? 0
        : item.sumOfRating / item.numberOfPeopleWhoRatedId * 1.0d;
    }

    @Override
    public MenuItem getRecommendedItem() {
        MenuItem recommendedItem = null;
        if (dealOfTheDayItem != null) {
            recommendedItem = dealOfTheDayItem;
        } else {
            // no deal of the day, return highest average rating
            PriorityQueue<MenuItem> queue = new PriorityQueue<>(
                (item1, item2) -> {
                    double averageRating1 = getAverageRating(item1);
                    double averageRating2 = getAverageRating(item2);
                    int averageRatingComparison = Double.compare(averageRating2, averageRating1); //descending
                    if(averageRatingComparison != 0){
                        return averageRatingComparison;
                    }

                    int numRatingComparison = Integer.compare(item2.numberOfPeopleWhoRatedId, item1.numberOfPeopleWhoRatedId); //descending
                    if(numRatingComparison != 0){
                        return numRatingComparison;
                    }

                    int num1 = extractNumber(item1.displayName);
                    int num2 = extractNumber(item2.displayName);
                    if(Integer.compare(num2, num1) != 0){
                        return Integer.compare(num2, num1);
                    }                        

                    return item1.itemId - item2.itemId; //lower id
                }
            );

            for(MenuItem item : inStockItems.values()){
                queue.offer(item);
                if(queue.size() > 1){
                    queue.poll();
                }
            }

            recommendedItem = queue.poll();
            if(recommendedItem.numberOfPeopleWhoRatedId == 0){
                recommendedItem = null;
            }
        }

        return recommendedItem;
    }

    @Override
    public void makeDealOfTheDayItem(int itemId) {
        MenuItem item = inStockItems.get(itemId);
        if (item != null) {
            dealOfTheDayItem = item;
        }
    }

    @Override
    public void outOfStockItem(int itemId) {
        MenuItem item = inStockItems.get(itemId);
        if (item != null) {
            inStockItems.remove(itemId); // remove from instock and add to outofstock
            outOfStockItems.put(itemId, item);
            if (dealOfTheDayItem != null && dealOfTheDayItem.itemId == item.itemId) {
                dealOfTheDayItem = null; // out of stock will not retain deal of the day
            }
        }
    }

    @Override
    public void rateItem(int itemId, int rating) {
        MenuItem item = inStockItems.get(itemId);
        if (item == null) {
            item = outOfStockItems.get(itemId);
        }
        if (item != null) {
            item.numberOfPeopleWhoRatedId += 1;
            item.sumOfRating += rating;
        }
    }

    @Override
    public void restockItem(int itemId) {
        MenuItem item = outOfStockItems.get(itemId);
        if (item != null) {
            outOfStockItems.remove(itemId); // remove from outofstock and add to instock
            inStockItems.put(itemId, item);
        }
    }

}

//your coding ends at here ........

// this refers to the "Main" class given in the problem - you dont need to write this
public class Oop_MenuRecommendation { // public class Main
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\workspace\\ptl-oa\\src\\main\\resources\\menu-recommendation.txt"));
        PrintWriter out = new PrintWriter(System.out, true);
        int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());

        String arr[];

        IMenuRecommendation menuRecommendation = new MenuRecommendation();

        for (int requestNumber = 1; requestNumber <= totalNumberOfRequests; requestNumber++) {
            arr = br.readLine().trim().split(" ");
            switch (arr[0]) {
                case "addItem":
                    int id = Integer.parseInt(arr[1]);
                    String displayName = arr[2];
                    menuRecommendation.addItem(id, displayName);
                    break;
                case "getRecommendedItem":
                    MenuItem menuItem = menuRecommendation.getRecommendedItem();
                    if (menuItem == null) {
                        out.println("N/A");
                        break;
                    }
                    double averageRating = (menuItem.numberOfPeopleWhoRatedId == 0) ? 0
                            : (menuItem.sumOfRating / (menuItem.numberOfPeopleWhoRatedId * 1.0d));
                    out.println(menuItem.itemId + " " + menuItem.displayName + " Rating: " + averageRating);
                    break;
                case "outOfStockItem":
                    int itemId = Integer.parseInt(arr[1]);
                    menuRecommendation.outOfStockItem(itemId);
                    break;
                case "restockItem":
                    itemId = Integer.parseInt(arr[1]);
                    menuRecommendation.restockItem(itemId);
                    break;
                case "makeDealOfTheDayItem":
                    itemId = Integer.parseInt(arr[1]);
                    menuRecommendation.makeDealOfTheDayItem(itemId);
                    break;
                case "rateItem":
                    itemId = Integer.parseInt(arr[1]);
                    int rating = Integer.parseInt(arr[2]);
                    menuRecommendation.rateItem(itemId, rating);
                    break;
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}
