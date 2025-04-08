package com.ptl.exercise.Walmart;

import java.util.*;
import java.util.stream.Collectors;

interface IVehicle{
    void setMake(String make);
    String getMake();
    void setModel(String model);
    String getModel();
    void setYear(int year);
    int getYear();
    void setPrice(int price);
    int getPrice();
}

interface IInventory{
    void addVehicle(IVehicle vehicle);
    void removeVehicle(IVehicle vehicle);
    int calculateTotalValue();
    List<IVehicle> getVehiclesByModel(String model);
    Map<Integer, List<IVehicle>> getVehiclesByYear();
    List<Triple<Integer, Integer, List<IVehicle>>> getVehiclesByYearRange();
}

class Triple<T, U, V>{
    private final T first;
    private final U second;
    private final V third;

    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public V getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "Triple [start=" + first + ", end=" + second + ", list=" + third + "]";
    }

    //add this for print
    
}


/*
 * Req 1
 * create the vehicle class and implement the IVehicle interface with the following fields
 * make(string), model(string), year(int), price(int)
 * 
 * Answer:
 * 1. define 4 fields
 * 2. add two constructors: empty one and one with all fields
 * 3. implement the getter, setters in IVehcile interface , add @Override
 */
class Vehicle implements IVehicle{

    private String make;
    private String model;
    private int year;
    private int price;

    public Vehicle(){ }
    
    public Vehicle(String make, String model, int year, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }


    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Vehicle [make=" + make + ", model=" + model + ", year=" + year + ", price=" + price + "]";
    }

    

}
class Inventory implements IInventory{

    //Req 2: Add a field to store the vehicles;
    List<IVehicle> vehicles = new ArrayList<>();

    //Req 3: implement all the IInventory methods
    @Override
    public void addVehicle(IVehicle vehicle) {
        //req 3.1 add vehicle to list
        vehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(IVehicle vehicle) {
        //req 3.2 remove the vehcile from the list
        if(vehicle != null && !vehicles.isEmpty()){
            //compare vehicle with those in vehicles list by year, make, model
            //if found target, remove it -- use iterator to prevent fail fast
            Iterator<IVehicle> it = vehicles.iterator();
            while(it.hasNext()){
                IVehicle target = it.next();
                if(target.getMake().equalsIgnoreCase(vehicle.getMake()) && target.getModel().equalsIgnoreCase(vehicle.getModel()) && target.getYear() == vehicle.getYear()){
                    it.remove();
                }
            }
        }
    }

    @Override
    public int calculateTotalValue() {
        // req 3.3: return total value of all vehicles
        if(vehicles.isEmpty()){
            return 0;
        }else{
            return vehicles.stream().mapToInt(v -> v.getPrice()).sum();
        }
    }

    @Override
    public List<IVehicle> getVehiclesByModel(String model) {
        // req 3.4: return list of vehicles match the given model, SORT by make
        List<IVehicle> results = new ArrayList<>();
        if(model == null || model.length() == 0 || vehicles.isEmpty()){
            return results;
        }
        results = vehicles.stream().filter(v -> v.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
        //sort by make
        if(!results.isEmpty()){
            Collections.sort(results, (v1, v2) -> v1.getMake().compareTo(v2.getMake()));
        }
        return results;
    }

    @Override
    public Map<Integer, List<IVehicle>> getVehiclesByYear() {
        // req 3.5: return a map, where each entry contains a year as key, and the value is a list of IVehicle objects from that year sorted by make
        Map<Integer, List<IVehicle>> map = new HashMap<>();
        if(!vehicles.isEmpty()){
            map = vehicles.stream().collect(Collectors.groupingBy(v -> v.getYear()));
            //now sort by make
            for(int year: map.keySet()){
                Collections.sort(map.get(year), (v1,v2) -> v1.getMake().compareTo(v2.getMake()));
            }
        }
        return map;
    }

    //@SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<Triple<Integer, Integer, List<IVehicle>>> getVehiclesByYearRange() {
        // Req 3.6: return list of triples, where each triple contains a start year(int), end year(int), and a list
        //of IVehicle objects sorted by the make of the vehicles within that year range. The date ranges will be set as 2011-2015,
        //2016-2020, and 2021-2023
        List<Triple<Integer, Integer, List<IVehicle>>> results = new ArrayList<>();
        int[][] yearRanges = {{2011, 2015}, {2016, 2020}, {2021, 2023}};
        if(!vehicles.isEmpty()){
            for(int[] yearRange: yearRanges){
                int start = yearRange[0];
                int end = yearRange[1];
                List<IVehicle> list = vehicles.stream().filter(v -> v.getYear() >= start && v.getYear() <= end).collect(Collectors.toList());
                Collections.sort(list, (v1,v2) -> v1.getMake().compareTo(v2.getMake()));
                results.add(new Triple(start, end, list));
            }
        }
        return results;
    }

}



//main test class
public class Oop_VehicleOperationsManagement {
    //test
    static IInventory inventory = new Inventory();

    public static void main(String[] args) {

        for (int i = 1; i <= 15; i++){
            int year = 2010 + i;
            String make = "make" + i;
            String model = "model" + i;
            int price = i;
            IVehicle vehicle = new Vehicle(make, model, year, price);
            inventory.addVehicle(vehicle);
        }
    
        System.out.println(inventory.getVehiclesByModel(null));
        System.out.println(inventory.getVehiclesByModel("model2")); //should be 1 result
        System.out.println(inventory.calculateTotalValue());
        System.out.println(inventory.getVehiclesByYear());
        System.out.println(inventory.getVehiclesByYearRange());

        //test remove
        Vehicle removedVehicle = new Vehicle("make2", "model2", 2012, 2);
        inventory.removeVehicle(removedVehicle);
        System.out.println(inventory.getVehiclesByModel("model2")); //should be [] empty
    }

    
}