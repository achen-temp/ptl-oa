package com.ptl.exercise.Altimetrik;

import java.util.*;

//print 1 to n in two thread, even and odd
class MyRunnable implements Runnable {
    public int n;
    public int num;
    public boolean printEven;

    static Object lock = new Object();

    public MyRunnable(int num, int n, boolean printEven) {
        this.n = n;
        this.num = num;
        this.printEven = printEven;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (num <= n) {
                if (num % 2 != (printEven ? 1 : 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    System.out.print(num + ",");
                }
                lock.notifyAll();
                num++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable(1, 10, false));
        Thread t2 = new Thread(new MyRunnable(1, 10, true));
        t1.start();
        t2.start();
    }
}

//print 1 to n in two thread, even and odd
class MyClass {
    public int start;
    public int end;

    public MyClass(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public synchronized void printNumber(boolean isEven) {
        while (start < end) {
            if (start % 2 == (isEven ? 1 : 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(start++ + ",");
            notify();
        }
    }

    public static void main(String[] args) {
        int start = 1, end = 10;
        MyClass solution = new MyClass(start, end);
        Thread t1 = new Thread(() -> solution.printNumber(true));
        Thread t2 = new Thread(() -> solution.printNumber(false));
        t1.start();
        t2.start();
    }
}

class Kaleb_11212022 {
    /**
     * given N, find all consecutive combinations that sum to N
     * given N = 5; return [{2,3},{5}]
     */
    public static List<List<Integer>> findSum(int N){
        int p1 = 1;
        int p2 = N % 2 == 0 ? N / 2 : ( (N+1) / 2);

        List<List<Integer>> result = new ArrayList<>();
        while(p1 < p2){
            int sum = 0;
            for(int i = p1; i <= p2; i++){
                sum += i;
                if(N == sum){
                    List<Integer> list = new ArrayList<>();
                    for(int k = p1; k <= i; k++){
                        list.add(k);
                    }
                    result.add(list);
                    break;
                }
                if(N < sum){
                    break;
                }
            }
            p1++;
        }
        result.add(Arrays.asList(N));
        return result;
    }

    //given input array, {10,2,70,57,4,7}
    //cannot use sort or queue
    public static int[] order(int[] nums){
        int[] result = new int[nums.length];
        int k = 0;
        int count = 0;
        while(count < nums.length){
            int min = findMin(nums);
            result[k++] = min;
            count++;
            int max = findMax(nums);
            result[k++] = max;
            count++;
        }
        return result;
    }

    public static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        int maxI = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= max && nums[i] != Integer.MAX_VALUE){
                max = nums[i];
                maxI = i;
            }
        }
        nums[maxI] = Integer.MAX_VALUE;
        return max;
    }

    public static int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        int minI = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= min && nums[i] != Integer.MIN_VALUE){
                min = nums[i];
                minI = i;
            }
        }
        nums[minI] = Integer.MIN_VALUE;
        return min;
    }

    //given input array, {10,2,70,57,4,7}
    //cannot use sort or queue
    //self implemented buble sort
    public static int[] order2(int[] nums){
        int[] result = new int[nums.length];

        //self implement bubble sort
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length; j++){
                if(nums[j - 1] > nums[j]){ //swap with previous element
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        //nums sorted now
        int p1 = 0, p2 = nums.length - 1;
        int k = 0;
        while(p1 < p2){
            result[k++] = nums[p1++];
            result[k++] = nums[p2--];
        }
        if(p1 == p2){
            result[k++] = nums[p1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("----output1---------");
        int N = 9;
        List<List<Integer>> result = findSum(N);
        System.out.println(result);

        System.out.println("----output2---------");

        int[] nums2 = {10,2,70,57,4,7,15};
        int[] result2 = order(nums2);
        System.out.println(Arrays.toString(result2));
    }

}

class AndySong_11232022{
    //    //given input array, {10,2,70,57,4,7}
    //    //cannot use sort or queue
    public static int[] reorder(int[] nums){
        if(nums == null || nums.length == 0){
            return nums;
        }
        int k = 0;
        Set<Integer> visited = new HashSet<>();
        int[] result = new int[nums.length];
        while(k < nums.length){
            int min = find(nums, true, visited);
            result[k++] = min;
            int max = find(nums, false, visited);
            if(k < nums.length){
                result[k++] = max;
            }
        }
        return result; //我的main在最底下
    }

    public static int find(int[] nums, boolean findMin, Set<Integer> visited){
        if(findMin){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                if(visited.contains(i)){
                    continue;
                }else{
                    if(num < min){
                        min = num;
                        minIndex = i;
                    }
                }
            }
            visited.add(minIndex);
            return min;
        }else{ //把if部分的copy到else然后修改红色部分
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                if(visited.contains(i)){
                    continue;
                }else{
                    if(num > max){
                        max = num;
                        maxIndex = i;
                    }
                }
            }
            visited.add(maxIndex);
            return max; //回到上面那个method
        }
    }

    //same: consecutive sum equal to N
    public static List<List<Integer>> getSum(int n){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                if(sum < n){
                    continue;
                }else if(sum > n){
                    break;
                }else{ // =
                    List<Integer> list = new ArrayList<>();
                    for(int k = i; k <= j; k++){
                        list.add(k);
                    }
                    result.add(list);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSum(9));
    }


}
public class Coding {

    //convert string number to integer "123" -> 123
    public static int convert(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            return (-1) * convert(s.substring(1));
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            result = result * 10 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "-123";
        int result = convert(s);
        System.out.println(result);
    }
}
