package com.ptl.exercise.ig.magnitGlobal;

public class Ood_StudentEnrollmentNumber {

}

// write above the "solution" class
class Student {

    private static int enrollmentNumber = 0;
    private String name;

    public Student(String name) {
        enrollmentNumber++;
        this.name = name;
    }

    public String toString(){
        return enrollmentNumber + ": " + this.name;
    }
}