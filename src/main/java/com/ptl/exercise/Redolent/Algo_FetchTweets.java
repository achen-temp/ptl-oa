package com.ptl.exercise.redolent;

import java.util.*;

public class Algo_FetchTweets {

}


class Tweet {
    int id, xCoord, yCoord;

    public Tweet(int xCoord, int yCoord, int id) {
        this.id = id;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
}

//this code pass 7/9 test cases,  the top 2 test cases not pass due to result mismatch, but dont know why, because cannot see the expected output32
class FetchTweets {
    private Map<Integer, Map<Integer, List<Tweet>>> grid; // Store tweets at (x, y) locations
    private static final int[][] DIRECTIONS = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }; // Right, Left, Down, Up

    public FetchTweets() {
        grid = new HashMap<>();
    }

    public void storeTweet(int xCoord, int yCoord, int id) {
        grid.putIfAbsent(xCoord, new HashMap<>());
        grid.get(xCoord).putIfAbsent(yCoord, new ArrayList<>());
        grid.get(xCoord).get(yCoord).add(new Tweet(xCoord, yCoord, id));
    }

    public Tweet[] fetchTweets(int xCoordOfUser, int yCoordOfUser, int K) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<Tweet> result = new ArrayList<>();

        queue.offer(new int[]{xCoordOfUser, yCoordOfUser});
        visited.add(xCoordOfUser + "," + yCoordOfUser);

        while (!queue.isEmpty() && result.size() < K) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            // Add all tweets at this location (if any) to the result
            if (grid.containsKey(x) && grid.get(x).containsKey(y)) {
                result.addAll(grid.get(x).get(y)); // Collect all tweets without sorting here
            }

            // Expand BFS to 4-neighbors (right, left, down, up)
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0], newY = y + dir[1];
                String key = newX + "," + newY;
                if (newX >= 1 && newX <= 10 && newY >= 1 && newY <= 10 && !visited.contains(key)) {
                    queue.offer(new int[]{newX, newY});
                    visited.add(key);
                }
            }
        }

        result.sort((a, b) -> {
            int distA = (a.xCoord - xCoordOfUser) * (a.xCoord - xCoordOfUser) +
                        (a.yCoord - yCoordOfUser) * (a.yCoord - yCoordOfUser);
            int distB = (b.xCoord - xCoordOfUser) * (b.xCoord - xCoordOfUser) +
                        (b.yCoord - yCoordOfUser) * (b.yCoord - yCoordOfUser);

            if (distA != distB) return Integer.compare(distA, distB); // Sort by distance
            if (a.xCoord != b.xCoord) return Integer.compare(a.xCoord, b.xCoord); // Sort by xCoord
            if (a.yCoord != b.yCoord) return Integer.compare(a.yCoord, b.yCoord); // Sort by yCoord
            return 0; // Maintain insertion order
        });

        // Return only the top K tweets
        return result.subList(0, Math.min(K, result.size())).toArray(new Tweet[0]);
    }
}
