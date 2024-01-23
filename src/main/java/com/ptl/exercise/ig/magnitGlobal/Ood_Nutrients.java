package com.ptl.exercise.ig.magnitGlobal;

public class Ood_Nutrients {

}

abstract class Food {
    double proteins;
    double fats;
    double carbs;
    double tastyScore;

    abstract void getMacroNutrients();
}

class Egg extends Food {

    int tastyScore = 7;
    String type = "non-vegetarian";

    public Egg(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public void getMacroNutrients() {
        System.out.println("An egg has " + this.proteins + " gms of protein, "
                + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates.");
    }
}

class Bread extends Food {

    int tastyScore = 8;
    String type = "vegetarian";

    public Bread(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public void getMacroNutrients() {
        System.out.println("A slice of bread has  " + this.proteins + " gms of protein,  " + this.fats
                + " gms of fats and  " + this.carbs + " gms of carbohydrates.");
    }
}
