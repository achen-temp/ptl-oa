package com.ptl.exercise;

import jnr.ffi.annotations.In;

import java.io.IOException;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void solve(int m, int n, int[][] matrix){
        Stack<Integer> stack = new Stack<Integer>();
        int i, k = 0, l = 0;
        while( k <= m && l <= n ){
            for(i = l; i <= n; i++){
                stack.push(matrix[k][i]);
            }
            k++;
            for(i = k; i <= m; i++){
                stack.push(matrix[i][n]);
            }
            n--;
            if(k <= m){
                for(i = n; i >= l; i--){
                    stack.push(matrix[m][i]);
                }
                m--;
            }
            if(l <= n){
                for(i = m; i >= k; i--){
                    stack.push(matrix[i][l]);
                }
                l++;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }

//38 shi l bushi i

    public static void main2(String[] args) throws IOException {
        //写这个把 -- 太变态了 输入都要自己写
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String row1 = br.readLine();
        String[] str1 = row1.replaceAll("\\s+$", "").split(" ");
        int row = Integer.parseInt(str1[0]);
        int col = Integer.parseInt(str1[1]);
        int[][] matrix = new int[row][col];
        String line;
        int i = 0;
        while( (line = br.readLine()) != null ){
            String[] arr = line.replaceAll("\\s+$", "").split(" ");
            for(int k = 0; k < col; k++){
                matrix[i][k] = Integer.parseInt(arr[k]);
            }
            i++;
        }
        */
        int row = 4;
        int col = 4;
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        Test.solve(row-1, col-1, matrix); //不知道了看没问题的
        //
    }


    public static double findPi(int n){
        if(n <= 0){
            return -1; //not valid -- 写上
        }
        double pi2 = 0;
        for(int i = 1; i <= n; i++){
            pi2 += 1.0/(i * i);
        }
        return Math.sqrt(6*pi2);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0, buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            max = Math.max(prices[i] - buy, max);
        }
        return max;
    }

    public static int[] method(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        //buy和sell是买入和卖出数
        int buy = arr[0], sell = arr[1], profit = sell - buy;

        int tempProfit = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            tempProfit = arr[i] - buy;
            if(tempProfit > profit){ //every value, find temporary profit and it bigger, replace 'profit'
                profit = tempProfit;
                sell = arr[i]; //update new sell price to search for another profit
            }
            if(buy > arr[i]){ //update current buy price with current stock price to find minimal buy price
                buy = arr[i];
            }
        }
        int[] result = new int[2];
        result[0] = sell - profit; // buy may not be updated finally, so use sell-profit
        result[1] = sell;
        return result;
    }


    public static void main(String[] args) {
        //int[] result = method(new int[]{21,12,11,9,6,3});
        //System.out.println(Arrays.toString(result));
        List<Team> teams = new ArrayList<>();
        List<Player> list1 = new ArrayList<>();
        list1.add(new Player(11,"p11"));
        list1.add(new Player(12,"p12"));
        list1.add(new Player(13,"p13"));
        teams.add(new Team(1000, list1));
        List<Player> list2 = new ArrayList<>();
        list2.add(new Player(21,"p21"));
        list2.add(new Player(22,"p22"));
        list2.add(new Player(23,"p23"));
        teams.add(new Team(2000, list2));

        List<Player> all = teams.stream().map(team -> team.players).flatMap(p -> p.stream()).collect(Collectors.toList());
        System.out.println(all);
    }

}

class Team{
    public int id;
    List<Player> players = new ArrayList<>();
    public Team(int id, List<Player> players){
        this.id = id;
        this.players.addAll(players);
    }
}
class Player{
    public int id;
    public String name;
    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + "," + name + "]";
    }
}


class Test1 {

    public static int rearrange(String s) {
        //String s = Integer.toString(num);
        int[] digits = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            digits[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (digits[i] > 0) {
                for (int k = 0; k < digits[i]; k++) {
                    sb.append(i);
                }
            }

        }
        return Integer.valueOf(sb.toString());
    }

    public <T> T getMaxDate(List<T> dates){
        return (T)dates.stream().map(v -> (Date)v).max(Date::compareTo).get();
    }

    public static void main(String[] args) throws Exception{
        Method method = Test1.class.getDeclaredMethod("getMaxDate", List.class);
        Type[] parameterTypes = method.getGenericParameterTypes();
        Type parameterType = parameterTypes[0];
        ParameterizedType parameterizedType = (ParameterizedType) parameterType;
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        for(Type typeArgument: typeArguments){
            System.out.println(typeArgument.getTypeName()); //T
        }
    }

}

class MyTest{
    public static void main(String[] args) {
        List<Shift> shifts = new ArrayList<>();
        shifts.add(new Shift(8, 10));
        shifts.add(new Shift(5, 10));
        shifts.add(new Shift(5, 9));
        List<Shift> result = combineOverlaps(shifts);
        for (Shift shift : result){
            System.out.println(shift.getStart() + "," + shift.getEnd());
        }
    }

    public static List<Shift> combineOverlaps(List<Shift> shifts){
        List<Shift> result = new ArrayList<>();
        if(shifts == null || shifts.size() == 0){
            return result;
        }
        Collections.sort(shifts, (s1, s2) -> s1.getStart() - s2.getStart() == 0 ? s1.getEnd() - s2.getEnd() : s1.getStart() - s2.getStart());
        int p1 = 0, p2 = p1 + 1;
        while(p1 < p2 && p2 < shifts.size()){
            Shift s1 = shifts.get(p1);
            Shift s2 = shifts.get(p2);
            if( s1.getEnd()< s2.getStart()){ //no overlap
                result.add(s1);
                p1 = p2;
                p2 = p1 + 1;
                if(p2 >= shifts.size()){
                    result.add(s2);
                }
            }else{ //has overlap
                Shift shift = new Shift(s1.getStart(), s2.getEnd());
                shifts.set(p2, shift);
                p1 = p2;
                p2 = p2 + 1;
                if(p2 >= shifts.size()){
                    result.add(shift);
                }

            }
        }
        return result;
    }
}

class Shift{
    int start;
    int end;

    public Shift(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

class QuickSort{
    public static void main(String[] args) {
        int[] arr = {5,2,4,1,3};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}

class IgWalmart{

    //static List<Integer> result = new ArrayList<>(); //host results

    //find all combinations that can get total amount and then select the one with shortest length
    public static List<Integer> calculateCoins(int[] coins, int[] size, int amount){
        List<List<Integer>> result = new ArrayList<>();
        //dfs(coins, size,0, amount, new ArrayList<>(), result);
        helper(coins, amount, result);
        Collections.sort(result, (list1, list2) -> list1.size() - list2.size());
        return result.get(0);
    }

    public static void helper(int[] coins, int amount, List<List<Integer>> res) {
        List<Integer> curr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int rem = amount;
        while (true) {
            if (rem <= 0 || index >= coins.length) {
                if(rem == 0) {
                    res.add(new ArrayList<>(curr));
                }
                if (stack.isEmpty()) { //here
                    break;
                }
                //sum over target, need to revert stack, list and sum to previous
                index = stack.pop();
                rem += coins[index];
                curr.remove(curr.size() - 1);
                index++;
            } else {
                //sum still smaller than target, we can keep adding
                stack.push(index);
                curr.add(coins[index]);
                rem -= coins[index];
            }
        }
    }

    private static void dfs(int[] coins, int[] size, int start, int amount, List<Integer> list, List<List<Integer>> result){
        if(amount <= 0){
            if(amount == 0) {
                if (result == null || result.size() == 0 || list.size() < result.size()) {
                    result.add(new ArrayList<>(list));
                }
            }
            return;
        }

        for(int i = start; i < coins.length; i++){
            if(size[i] > 0) {
                list.add(coins[i]);
                size[i]--;
                dfs(coins, size, i, amount - coins[i], list, result);
                list.remove(list.size() - 1);
                size[i]++;
            }
        }
    }


    public static List<Integer> calculateCoins_BFS(int[] coins, int[] counts, int amount) {
         //every node could have n children node
        Queue<Node> queue = new LinkedList<>();
        for(int coin : coins){
            queue.add(new Node(coin, null));
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.sum == amount){
                return curr.list;
            }else if(curr.sum < amount){
                for(int i = 0; i < coins.length; i++) {
                    int coin = coins[i];
                    queue.add(new Node(coin, curr));
                }
            }
        }
        return result;
    }

    static class Node{
        int val;
        List<Integer> list; //1,2,2,5 -- COUNT=[1,1,5]
        int sum;
        public Node(int val, Node parent){
            this.val = val;
            if(parent == null){ //top nodes
                this.list = new ArrayList<>();
                this.list.add(val);
                this.sum = val;
            }else{ //update list and sum using parent value
                this.list = new ArrayList<>(parent.list);
                this.list.add(val);
                this.sum = parent.sum + val;
            }
        }

    }

    public static void main(String[] args) {
        int[] coins = {1,3,4,5};
        int[] size = {10,10,10};
        int amount = 7;
        //Collections.sort(result, (list1, list2) -> list1.size() - list2.size());
        //System.out.println(result.get(0));
        System.out.println(calculateCoins_DP(coins,size,amount));
    }

    //build dp[0],dp[1]....dp[amount] to store all results with sum equal to 0,1,2,...amount
    //dp[k] store all combinations with sum equal to k
    //for each input element s: dp[k+1] = dp[k+1-s] + s;
    public static List<Integer> calculateCoins_DP(int[] coins, int[] coinAmounts, int amount){
        Arrays.sort(coins); //must sort
        List<List<Integer>>[] dp = new List[amount + 1]; //
        for(int i = 0; i <= amount; i++){
            dp[i] = new ArrayList<>();
        }
        for(int sum = 0; sum <= amount; sum++){
            for(int i = 0; i < coins.length; i++){
                if(sum == coins[i]){
                    List<Integer> list = new ArrayList<>();
                    list.add(coins[i]);
                    dp[sum].clear();
                    dp[sum].add(list);
                }else if(coins[i] < sum){
                    int diff = sum - coins[i];
                    List<List<Integer>> lists = dp[diff];
                    Collections.sort(lists, (l1, l2) -> l1.size() - l2.size());
                    int size = lists.get(0).size();
                    for(List<Integer> item : lists){
                        if(item.size() == size){
                            dp[sum].add(new ArrayList<>(item));
                        }
                    }
                }else{
                    break;
                }
            }
        }
        return dp[amount].get(0);
        /*
        List<List<Integer>> allCombinations = dp[amount];
        System.out.println(allCombinations);
        if(allCombinations.size() == 0){
            return new ArrayList<>();
        }else{
            Collections.sort(allCombinations, (l1, l2) -> l1.size() - l2.size());
            return allCombinations.get(0);
        }*/
    }
}

class Airbnb{
    public static int[][] sort(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return matrix;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int key = i - j;
                if(map.containsKey(key)){
                    map.get(key).offer(matrix[i][j]);
                }else{
                    Queue<Integer> list = new PriorityQueue<>();
                    list.add(matrix[i][j]);
                    map.put(key, list);
                }
            }
        }

        //build back matrix
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int value = map.get(i - j).poll();
                result[i][j] = value;
            }
        }
        return result;
    }

    //let me write test case in the main method use your example
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindowSubstring(s, t));
    }



    public static String minWindowSubstring(String s, String t){

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if( ! map.containsKey(c) ){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        } //say: here map key is characters in t, and value is count of each character

        int p1 = 0, p2 = 0;
        int count = map.size();
        int result = Integer.MAX_VALUE;
        boolean notFound = true;
        int preP1 = 0;
        while(p2 < s.length()){
            char c2 = s.charAt(p2);
            if(map.containsKey(c2)){
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0){
                    count--;
                }
            }
            while(count == 0){
                if(p2 - p1 + 1 < result){
                    notFound = false;
                    result = p2 - p1 + 1;
                    preP1 = p1;
                }
                char c3 = s.charAt(p1);
                if(map.containsKey(c3)){
                    map.put(c3, map.get(c3) + 1);
                    if(map.get(c3) > 0){
                        count++;
                    }
                }
                p1++;
            }
            p2++;
        }
        return notFound ? "" : s.substring(preP1, preP1 + result);
    }

}

class StringTest{
    public static void main(String[] args) {
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                System.out.println("i:" + i + ", j: " + j + ", sub: " + sub);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                System.out.println("dp: " + Arrays.toString(dp));
            }
        }
        return dp[s.length()];
    }
}

class BOA{
    //find one pair
    public static int[] twoSum(int[] nums, int sum){
        if(nums == null || nums.length <= 1){
            return new int[0];
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(sum - num)){
                result[0] = map.get(sum - num);
                result[1] = i;
                break;
            }else{
                map.put(num, i);
            }
        }
        return result;
    }

    //find all pairs
    public static List<int[]> twoSum2(int[] nums, int sum){
        if(nums == null || nums.length <= 1){
            return null;
        }
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(sum - num)){
                int[] arr = new int[2];
                arr[0] = map.get(sum - num).get(0);
                arr[1] = i;
                result.add(arr);
                map.get(sum - num).remove(0);
                //break;
            }else{
                if(! map.containsKey(num)) {
                    map.put(num, new ArrayList<>());
                }
                map.get(num).add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,3};
        List<int[]> res = twoSum2(nums, 5);
        res.forEach(ar -> System.out.println(Arrays.toString(ar)));
    }
}

class Splits{

    public static List<List<List<Integer>>> splitArrayIntoKSubarrays(int[] arr, int k) {
        List<List<List<Integer>>> result = new ArrayList<>();
        splitArray(arr, k, 0, new ArrayList<>(), new ArrayList<>(), result);
        return result;
    }

    private static void splitArray(int[] arr, int k, int startIndex, List<Integer> currentSubarray, List<List<Integer>> currentResult, List<List<List<Integer>>> result) {
        if (k == 0) {
            // If we have used up all subarrays and processed all elements, add the current subarray to the result.
            result.add(new ArrayList<>(currentResult));
            return;
        }

        if (startIndex >= arr.length || k == 0) {
            // Invalid state, return without adding to the result.
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            currentSubarray.add(arr[i]);
            currentResult.add(currentSubarray);
            splitArray(arr, k - 1, i + 1, new ArrayList<>(), currentResult, result);
            currentResult.remove(currentResult.size() - 1);
            currentSubarray.remove(currentSubarray.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        List<List<List<Integer>>> subarrays = splitArrayIntoKSubarrays(arr, k);
        for (List<List<Integer>> kSubarrays : subarrays) {
            for (List<Integer> subarray : kSubarrays) {
                System.out.println(subarray);
            }
            System.out.println("---");
        }
    }
}

class Bart{

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "c");
        map.put(4, "a");
        map.put(2, "d");
        map.put(3, "b");
        map.entrySet().stream().sorted((e1, e2) -> e2.getKey() - e1.getKey()).forEach(e -> System.out.println(e.getKey() + "," + e.getValue()));
        map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(e -> System.out.println(e.getKey() + "," + e.getValue()));
    }

}

class Test22{
    static int[][] solution(int[][] bubbles, int[][] operations){
        for(int[] operation: operations){
            playerClick(bubbles, operation);
            boardUpdate(bubbles);
        }
        return bubbles;
    }

    static void playerClick(int[][] bubbles, int[] operation){
        int row = operation[0], col = operation[1];
        if(bubbles[row][col] != 0){
            if(bubbles[row - 1][col - 1] == bubbles[row][col]){
                bubbles[row - 1][col - 1] = 0;
            }
            if(bubbles[row - 1][col + 1] == bubbles[row][col]){
                bubbles[row - 1][col + 1] = 0;
            }
            if(bubbles[row + 1][col - 1] == bubbles[row][col]){
                bubbles[row + 1][col - 1] = 0;
            }
            if(bubbles[row + 1][col + 1] == bubbles[row][col]){
                bubbles[row + 1][col + 1] = 0;
            }
            bubbles[row][col] = 0;
        }
    }

    static void boardUpdate(int[][] board){
        //check every column, move all 0s up
        for(int col = 0; col < board[0].length; col++){

        }
    }


    public static void main(String[] args) {
        //1,2,2,1,3,4,5
        int[][] bubbles = {
                {1, 1, 1, 4, 3},
                {4, 1, 2, 3, 3},
                {1, 5, 1, 1, 1},
                {4, 3, 2, 2, 4}
        };

        int[][] operations = {
                {1, 1},
                {3, 3},
                {2, 2},
                {3, 0}
        };

        int[][] result = solution(bubbles, operations);

        // Print the result
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}