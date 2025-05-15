package com.ptl.exercise.collabera;

import java.util.*;

public class Coding {

}

// 1. question : tell me a mistake you made in project, how you solved it and what
// you learnt

// 2. leetcode 767 rearrange strings
// 3.  whoIsOurBoss, find lowest common ancestor: https://aaronice.gitbook.io/lintcode/trees/closet-common-manager
class CollaberaCoding {
    // leetcode 767 rearrange strings
    public String reorganizeString(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        // count
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> freq.get(b) - freq.get(a));
        pq.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 1) {
            char ch1 = pq.poll();
            char ch2 = pq.poll();

            sb.append(ch1);
            sb.append(ch2);

            freq.put(ch1, freq.get(ch1) - 1);
            freq.put(ch2, freq.get(ch2) - 1);

            if (freq.get(ch1) > 0)
                pq.add(ch1);
            if (freq.get(ch2) > 0)
                pq.add(ch2);
        }

        if (!pq.isEmpty()) {
            char last = pq.poll();
            if (freq.get(last) > 1)
                return ""; // Can't place without adjacent repeat
            sb.append(last);
        }

        return sb.toString();
    }

    //lowest common ancestor
    public static Employee whoIsOurBoss(Employee ceo, Employee emp1, Employee emp2) {
        if (ceo == null || ceo == emp1 || ceo == emp2) {
            return ceo;
        }
        boolean judgeemp1 = false;
        boolean judgeemp2 = false;
        for (Employee em: ceo.reports){
            Employee result = whoIsOurBoss(em, emp1, emp2);
            if (result == emp1) {
                judgeemp1 = true;
            } else if (result == emp2) {
                judgeemp2 = true;
            } else if (result != null) {
                return result;
            }
        }
        if (judgeemp1 == true && judgeemp2 == true) {
            return ceo;
        } else if (judgeemp1 == true) {
            return emp1;
        } else if (judgeemp2 == true) {
            return emp2;
        }
        return null;
    }

    public static void main(String[] args) {
        Employee ceo = new Employee("Bill");
        Employee dom = new Employee("Dom");
        Employee samir = new Employee("Samir");
        Employee michael = new Employee("Michael");
        ceo.reports.add(dom);
        ceo.reports.add(samir);
        ceo.reports.add(michael);

        Employee peter = new Employee("Peter");
        Employee bob = new Employee("Bob");
        Employee porter = new Employee("Porter");
        dom.reports.add(peter);
        dom.reports.add(bob);
        dom.reports.add(porter);

        Employee milton = new Employee("Milton");
        Employee nina = new Employee("Nina");
        peter.reports.add(milton);
        peter.reports.add(nina);

        System.out.println(whoIsOurBoss(ceo, milton, nina).name.equalsIgnoreCase("peter"));
        System.out.println(whoIsOurBoss(ceo, milton, porter).name.equalsIgnoreCase("dom"));
        System.out.println(whoIsOurBoss(ceo, peter, samir).name.equalsIgnoreCase("bill"));
        System.out.println(whoIsOurBoss(ceo, dom, michael).name.equalsIgnoreCase("bill"));

    }
}


//GIVEN for who is our bosss problem
class Employee{
    int id;
    String name;
    Set<Employee> reports; //list of other employees who report to this employee

    Employee(String name){
        this.name = name;
        this.reports = new HashSet<>();
    }
}


/*
        Bill --> CEO
       /     |    \
    DOM      SAMIR  MICHAEL
   /  \   \
  Peter Bob Porter
 /     \
Milton Nina
 */