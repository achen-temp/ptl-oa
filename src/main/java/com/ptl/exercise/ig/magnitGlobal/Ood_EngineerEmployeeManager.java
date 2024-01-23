package com.ptl.exercise.ig.magnitGlobal;

public class Ood_EngineerEmployeeManager {
    
}

//write on top of the solution class, about line 6

abstract class Employee{
     abstract void setSalary(int salary);
     abstract int getSalary();
     abstract void setGrade(String grade);
     abstract String getGrade();
     public void label(){
           System.out.println("Employee's data:");
     }
}

class Engineer extends Employee{ 
       private int salary;
       private String grade;
       public void setSalary(int salary){
             this.salary = salary;
       }
       public int getSalary(){
            return this.salary;
       }
       public void setGrade(String grade){
             this.grade = grade;
       }
       public String getGrade(){
             return this.grade;
       }
}

class Manager extends Employee{
       private int salary;
       private String grade;
       public void setSalary(int salary){
             this.salary = salary;
       }
       public int getSalary(){
            return this.salary;
       }
       public void setGrade(String grade){
             this.grade = grade;
       }
       public String getGrade(){
             return this.grade;
       }
}

