package com.ptl.exercise.Aditi;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


class X{
    X(){
        System.out.println("a");
    }
    void X(){
        System.out.println("b");
    }
}

class Y extends X{
    void Y(){
        X();
        System.out.println("c");
    }
}

class MainClass{
    public static void main(String[] args) {
        Y y = new Y();
        y.Y();
    }
}

interface Movement{
    void goTo(String destination);
}
class Walking implements Movement{
    @Override
    public void goTo(String destination) {
        System.out.println("walking to" + destination);
    }
}

class proxxx implements Movement{

    private String destination;
    private Movement movement;
    public proxxx(){
        this.movement = new Walking();
    }

    @Override
    public void goTo(String destination) {
        this.destination = destination;
        this.movement.goTo(destination);
    }
}

/**
 * 1.
 * three a  = new one()
 * Two b = new One()
 * Five f = new Three()
 *
 * 2. implements Movement
 *     Walking
 *     this.movement.goTo
 * wait,  let me take screenshot
 * 3. 中间是interface list
 * sortedset
 * 4. list.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList())
 * 5. code 1 returns first entry
 *     code 2 and 3 return last entry
 *
 * 6. CrudRepository
 *    StudentRepositoyr studentRepositoyr
 *   this. studentrrepostyr = studentRepsotyr;
 *
 * 7. @ RestController
 *    @GetMapping
 *    findAll
 * 8. HttpSecuirity
 *     authrozieRequests
 *     hasRole
 *
 * 1. C
 * 2. ENTITY
 * @ID
 * @TRANSIENT
 *
 * 3. aRITHMETICEZCEPTION
 *    nULLpOINTERSeXCEPTION
 *    FILENOTFOUND
 * 4. A: abc (E)
 *     B: default
 *      C: D
 * 5.  impleents
 *     Walking
 *   this.
 * 6. B+c+e
 *
 * good. submit
 * all new problems. its unexpected. but you should be able to pass
 */

public class Algo_LittleBrothersFactorialChallenge {

    //Solution 1: use BigInteger to calculate (didnot test with the Hackerrank test cases)
    public static List<Integer> solve2(int m, int n){
        //first find factorial of m
        List<Integer> result = new ArrayList<>();
        BigInteger mf = new BigInteger("1");
        for(int i = 1; i <= m - 1; i++){
            mf = mf.multiply(new BigInteger(String.valueOf(i)));
        }
        for(int i = m; i <= n; i++){
            mf = mf.multiply(new BigInteger(String.valueOf(i)));
            //System.out.println(i + " -- " + mf);
            if(Integer.valueOf(String.valueOf(mf).charAt(0)).intValue() % 2 == 0){
                result.add(i);
            }
        }
        if(result.size() == 0){
            result.add(0);
        }
        return result;
    }

    //Solution 2: Passed all Hackerrank test cases -- must choose JAVA 8+
    public static List<Integer> solve(int m, int n){
        Integer[] groups = {2,3,4,8,
                12,13,14,16,18,
                20,23,24,26,29,
                30,31,32,33,34,39,
                40,43,44,47,49,
                52,53,54,57,58,
                60,65,68,
                71,72,73,75,79,
                82,85,86,87
        };
        //top choose java 8
        List<Integer> result = Arrays.stream(groups).filter(a -> a >= m && a <= n).collect(Collectors.toList());
        return result.size() == 0 ? Arrays.asList(0) : result;
    }

    /**
     * 说思路-读下面这个就可以：

     In this problem, we need to find all the numbers between m and n that having
     factorial starting with an even number, since M and N are between 1 to 100
     so I simply list all the numbers that between 1 to 100 that having factorial staring with even number and I put them all into an array.
     so for a given number M and N, we just list all the numbers in that array that is between M and N. that is my solution. Thank you!

     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solve(1,100));
        System.out.println(solve2(1,100));
    }

}