package com.ptl.exercise.kori.magnitGlobal;

public class Ood_StudentEnrollmentNumber {

}

// write about the "solution" class
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