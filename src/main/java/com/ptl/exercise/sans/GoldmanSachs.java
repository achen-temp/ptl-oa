package com.ptl.exercise.sans;

public class GoldmanSachs {
    
}
/*
//1. Liang Jiakang -- End of March
R1::::::: 2/16
1. Use java to for input string like aaa, bb, aa converted to the count of each letters in order 
like aaa will become a3, bb will become b2, aa will become a2. So aaa, bb, 
aa will output a3, b2, a2. Write java program.
2. LC: TrapWater, TrapSnow
FOLLOW UP: FOLLOW UP: 1. add ALL possible test cases 2)time and space complexity

R2:::::::: 2/23/2024
1. Design an online ecommerce platform, start from functional and non-functional design
Suppose it is a whole foods website, only one seller, Show me database schema, especially 
shopping cart schema.  List the APIs for this system.

2. Suppose we have transaction data comes as data stream, the transaction data has accountNumber
currency and amount. We need to find the amount for a transaction at a given time, waht data structure
to use to handle it?
Answer: Map<accountNumber, Map<Currency, Amount>>
OR (from interviewer: Map<accountNumber-Currency, Amount>)


//2. Weipei LONG -- William
R1:::::: 5/21/2024

R2::::: 5/23/2024
1. Given string, find the 1st unique character
2. find highest avareage score -- like below Shengkai Qin problem

//3. Wesley Yunqi Wang
R1::::::::  7/24/2024
1. LC4: Find median of two sorted array (no need to ues binary search, just use two pointers)
FOLLOW UP: FOLLOW UP: 1. add ALL possible test cases 2)time and space complexity
2. LC11: TrapWater, TrapSnow
FOLLOW UP: FOLLOW UP: 1. add ALL possible test cases 2)time and space complexity

//4. ShengKai Qin
R1::::::
P1:: find longest uniform substring return its two element aray, 
1st element is start of the substring, 2nd element is the length
example: abbbccda, return [1,3] because bbb is longest uniform, bbb starts at index 1 and length is 3
FOLLOW UP: 1. add more test cases 2)time and space complexity

P2:: ROCKER COLLECTOR
two dimensional array represents rocks, you are a rock collector, given origin and destination, 
you can only go up or right direction, find the maxmium rocks you can collect
        {{0, 0, 0, 0, 5}, Destination
         {0, 1, 1, 1, 0}
origin   {2, 0, 0, 0, 0}}
Ouput from origin to destination max rocks will be 10 （2 + 0 + 1 + 1 + 1 + 0 + 5)
FOLLOW UP: 1. add more test cases 2)time and space complexity

R2:::::::
MongoDB: explain how do you use mongodb in your project
Kafka: talk about how you use kafka in your project
Kafka: talk about how you prevent duplicate messages
Kafka: How to make sure two consumers not reading the same message

Coding1: Given X, return an array containing prime nubmers whose product is X
public static ArrayList<Integer> primeFactorization(int x){}
primeFactorization(6) == [2,3]
primeFactorization(5) == [5]
primeFactorization(12) == [2,2,3]
FOLLOW UP: 1. add more test cases 2)time and space complexity

Coding2: Student Avg Grade
Given two dimensional array [student name, test score], test score can be positive or negative
find the highest average score. If you end up average score is not integer, use floor function to return
the largest integer less than or equal to the average
return 0 for empty input
[["Bobby", "87"],
 ["Charles", "100"],
 ["Eric", "64"],
 ["Charles", "22"]].
 Expected: 87 --> average score are 87, 61, 64 for Bobby, Charles and Eric . so 87 is highest.
 FOLLOW UP: 1. add more test cases 2)time and space complexity

//5. KEVIN WANG -------
R1::::::::::::::
1. given original spot (0,0) and path, the path is a serial of letters UDLR
U means go right, D is down, L is left, R is right. Determine the final location

2. average score like above.
3. JS: have you used "addEventListener"? how do you use it
    if you have a table with 100 rows, each row has a button, you want to addEventListener to every button, 
    how do you do it?
    (answer: for loop to append for each row with id)
    (followup: but it will append 100 copies, how to avoid it, whats better way
    --- use event bubbling, explain event bubbling and explain how it works)

 */

/*
 * August/September 2024
 * 
 * Coding 1: World Shortest Distance 
 *   >  first interview: asks to fix the problem so all tests pass - the main problem is when the input
 *      input words end with puncs, it would be hard to split
 *   >  second interview: asks to write the coding from scratch
 *   KEY NOTES: As lnog as you can past their given test cases, it will be fine, Donot overthink for all possible scenairos
 *              See another file for details
 * 
 * Coding 2: Rocker Colletor as above
 * Coding 3: Student Avg Grade as above
 * Coding 4: String to Integer (atoi)
 *  >   They give a simple for loop and a wrong test case, you need to implement atoi by yourself and
 *      also self define all possible test cases. It is not hard.
 * 
 */