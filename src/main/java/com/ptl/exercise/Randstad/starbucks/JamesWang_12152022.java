package com.ptl.exercise.randstad.starbucks;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class JamesWang_12152022 {
}

class FindUniqueCharactersCount {
    //1. find unique words case in-sensitive
    //FOX, FENCE,TROUT, fox, FOX, FENCe, --> 3
    public static int count(String[] words) {
        //1. use hashset and convert to lower case
        //2. lambda
        long count = Arrays.stream(words).map(word -> word.toLowerCase()).distinct().count();
        System.out.println(count);

        //3. find count of each words
        Map<String, Integer> map = Arrays.stream(words).collect(Collectors.groupingBy(w -> w.toLowerCase(), Collectors.summingInt(w -> 1)));
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "," + entry.getValue()));

        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"FOX", "FENCE", "TROUT", "fox", "FOX", "FENCe" };
        count(words);
    }
}


//2. fix the problem in VehicleManagement

interface Vehicle {
    public void clean();
    public void inspect();
}

class Car implements Vehicle{
    public void clean() {
        System.out.println("car clean");
    }

    public void inspect() {
        System.out.println("car inspect");
    }

    public void checkMoonRoof() {
        System.out.println("car check moon roof");
    }
}

class Truck implements Vehicle {
    public void clean() {
        System.out.println("truck clean");
    }
    public void inspect() {
        System.out.println("truck inspect");
    }
}

class VehicleManagement {
    void process(Vehicle v) {
        v.clean();
        v.inspect();
        //v.checkMoonRoof(); //fix this line
        if(v instanceof Car){
            Car c = (Car) v;
            c.checkMoonRoof();
        }
        /**
         * 1. add checkMoonRoof to Vehicle interface -- works, but Truck needs implementing that method too.
         * 2. make CheckMoonRoof a DEFAULT method in interface VEHICLE  --- works perfectly
         * 3. if(v instanceOf Car){Car c = (Car) v;  c.checkMoonRoof();}  ---- works perfectly
         * 3. CREATE Another interface to include that check Moon Roof method ? - not working, compile error
         */
    }

    public static void main(String[] args) {
        VehicleManagement solution = new VehicleManagement();
        Car car = new Car();
        solution.process(car);
    }
}

