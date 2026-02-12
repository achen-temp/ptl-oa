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

// new answer pass all test
class FetchTweets {

    // grid[x][y] = list of tweets from coordinate (x, y) in insertion order
    private List<Tweet>[][] grid;
    private int totalTweets;

    @SuppressWarnings("unchecked")
    public FetchTweets() {
        // Coordinates are 1..10; index 0 is unused.
        grid = new ArrayList[11][11];
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                grid[x][y] = new ArrayList<>();
            }
        }
        totalTweets = 0;
    }

    void storeTweet(int xCoord, int yCoord, int id) {
        Tweet t = new Tweet(xCoord, yCoord, id);
        grid[xCoord][yCoord].add(t);   // append -> preserves insertion order
        totalTweets++;
    }

    Tweet[] fetchTweets(int xCoordOfUser, int yCoordOfUser, int K) {

        Tweet[] res = new Tweet[K];
        if (K == 0 || totalTweets == 0) {
            return res; // all nulls
        }

        // Helper class to represent a cell that actually has tweets
        class Cell {
            int x, y, distSq;
            Cell(int x, int y, int distSq) {
                this.x = x;
                this.y = y;
                this.distSq = distSq;
            }
        }

        List<Cell> cells = new ArrayList<>(100);

        // Collect all non-empty cells and compute their (squared) distance
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                if (!grid[x][y].isEmpty()) {
                    int dx = x - xCoordOfUser;
                    int dy = y - yCoordOfUser;
                    int distSq = dx * dx + dy * dy;
                    cells.add(new Cell(x, y, distSq));
                }
            }
        }

        if (cells.isEmpty()) {
            return res; // no tweets yet
        }

        // Sort cells by distance, then x, then y
        Collections.sort(cells, (a, b) -> {
            if (a.distSq != b.distSq) {
                return Integer.compare(a.distSq, b.distSq);
            }
            if (a.x != b.x) {
                return Integer.compare(a.x, b.x);
            }
            return Integer.compare(a.y, b.y);
        });

        int idx = 0;

        outer:
        for (Cell c : cells) {
            List<Tweet> list = grid[c.x][c.y];
            // Tweets in list are in insertion order -> oldest first
            for (Tweet t : list) {
                res[idx++] = t;
                if (idx == K) {
                    break outer;
                }
            }
        }

        // If we had fewer than K tweets in total,
        // remaining entries stay null as expected by the main.
        return res;
    }
}
//this code pass 7/9 test cases,  the top 2 test cases not pass due to result mismatch, but dont know why, because cannot see the expected output32
//class FetchTweets {
//    private Map<Integer, Map<Integer, List<Tweet>>> grid; // Store tweets at (x, y) locations
//    private static final int[][] DIRECTIONS = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }; // Right, Left, Down, Up
//
//    public FetchTweets() {
//        grid = new HashMap<>();
//    }
//
//    public void storeTweet(int xCoord, int yCoord, int id) {
//        grid.putIfAbsent(xCoord, new HashMap<>());
//        grid.get(xCoord).putIfAbsent(yCoord, new ArrayList<>());
//        grid.get(xCoord).get(yCoord).add(new Tweet(xCoord, yCoord, id));
//    }
//
//    public Tweet[] fetchTweets(int xCoordOfUser, int yCoordOfUser, int K) {
//        Queue<int[]> queue = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//        List<Tweet> result = new ArrayList<>();
//
//        queue.offer(new int[]{xCoordOfUser, yCoordOfUser});
//        visited.add(xCoordOfUser + "," + yCoordOfUser);
//
//        while (!queue.isEmpty() && result.size() < K) {
//            int[] current = queue.poll();
//            int x = current[0], y = current[1];
//
//            // Add all tweets at this location (if any) to the result
//            if (grid.containsKey(x) && grid.get(x).containsKey(y)) {
//                result.addAll(grid.get(x).get(y)); // Collect all tweets without sorting here
//            }
//
//            // Expand BFS to 4-neighbors (right, left, down, up)
//            for (int[] dir : DIRECTIONS) {
//                int newX = x + dir[0], newY = y + dir[1];
//                String key = newX + "," + newY;
//                if (newX >= 1 && newX <= 10 && newY >= 1 && newY <= 10 && !visited.contains(key)) {
//                    queue.offer(new int[]{newX, newY});
//                    visited.add(key);
//                }
//            }
//        }
//
//        result.sort((a, b) -> {
//            int distA = (a.xCoord - xCoordOfUser) * (a.xCoord - xCoordOfUser) +
//                    (a.yCoord - yCoordOfUser) * (a.yCoord - yCoordOfUser);
//            int distB = (b.xCoord - xCoordOfUser) * (b.xCoord - xCoordOfUser) +
//                    (b.yCoord - yCoordOfUser) * (b.yCoord - yCoordOfUser);
//
//            if (distA != distB) return Integer.compare(distA, distB); // Sort by distance
//            if (a.xCoord != b.xCoord) return Integer.compare(a.xCoord, b.xCoord); // Sort by xCoord
//            if (a.yCoord != b.yCoord) return Integer.compare(a.yCoord, b.yCoord); // Sort by yCoord
//            return 0; // Maintain insertion order
//        });
//
//        // Return only the top K tweets
//        return result.subList(0, Math.min(K, result.size())).toArray(new Tweet[0]);
//    }
//}
