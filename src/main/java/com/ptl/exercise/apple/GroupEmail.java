package com.ptl.exercise.apple;

import java.util.*;

public class GroupEmail {

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@gmail.com", "john00@gmail.com","john01@gmail.com", "john02@gmail.com"),
                Arrays.asList("John", "johnnybravo@gmail.com"),
                Arrays.asList("John", "johnsmith@gmail.com", "john_newyork@gmail.com"),
                Arrays.asList("Mary", "mary@gmail.com"));

        GroupEmail sol = new GroupEmail();
        List<List<String>> merged = sol.accountsMerge(accounts);
        System.out.println(merged);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> emailMap = new HashMap<>(); // email -> neighbors
        Map<String, String> nameMap = new HashMap<>(); //email -> name

        // Step 1: Build the graph
        for (List<String> account : accounts) {
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                for(int j = i; j < account.size(); j++){

                }
            }
            for (int i = 1; i < account.size(); i++) {
                nameMap.put(account.get(i), name);

                // build undirected graph between first email and rest
                if (i == 1)
                    continue;
                emailMap.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(account.get(i));
                emailMap.computeIfAbsent(account.get(i), x -> new ArrayList<>()).add(account.get(1));
                System.out.println(i + "  ----  " + emailMap);
            }
        }

        // Step 2: BFS to find connected components
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : nameMap.keySet()) {
            if (visited.contains(email))
                continue;

            Queue<String> queue = new LinkedList<>();
            List<String> emails = new ArrayList<>();
            queue.add(email);
            visited.add(email);

            while (!queue.isEmpty()) {
                String cur = queue.poll();
                emails.add(cur);
                for (String neighbor : emailMap.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            Collections.sort(emails);
            emails.add(0, nameMap.get(email)); // add name at front
            result.add(emails);
        }

        return result;
    }
}
