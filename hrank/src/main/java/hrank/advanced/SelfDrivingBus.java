package hrank.advanced;

import java.util.*;

public class SelfDrivingBus {
    static int solve(int[][] tree) {

        int n = tree.length + 1;

        Map<Integer, Set<Integer>> countryMap = new HashMap<>();
        Map<Integer, Set<Integer>> foundSets = new HashMap<>();

        int totalConnections = 0;

        for (int i = 1; i <= n; i++) {
            countryMap.put(i, new HashSet<Integer>());
            foundSets.put(i, new HashSet<Integer>());
//            foundSets.get(i).add(i);
        }

        for (int[] road : tree) {
//            if (road[0] < road[1]) {
            countryMap.get(road[0]).add(road[1]);
//            } else if (road[1] < road[0]) {
            countryMap.get(road[1]).add(road[0]);
//            }
        }



        Set<Integer> visited = new HashSet<>();
        for (int origin = 1; origin <= n; origin++) {
//            totalConnections++;
//            for (int neighbor : countryMap.get(origin)) {

            totalConnections += findSubsets(origin, origin, 0, origin, origin, foundSets, visited, countryMap);

//            }
        }

        return totalConnections;
    }

    private static int findSubsets(int current, int initial, int depth, int minFound, int maxFound, Map<Integer, Set<Integer>> foundSets, Set<Integer> visited, Map<Integer, Set<Integer>> countryMap) {
        if (current < initial) return 0;
        if (current > maxFound) maxFound = current;
//        if (current < minFound) minFound = current;

        int totalFound = 0;
        if (!foundSets.get(initial).contains(maxFound)) {
            if (depth == maxFound - initial) {
                totalFound++;
                foundSets.get(initial).add(maxFound);
            }
        }

        visited.add(current);
        for (int neighbor : countryMap.get(current)) {
            if (!visited.contains(neighbor)) {
                totalFound += findSubsets(neighbor, initial, depth + 1, minFound, maxFound, foundSets, visited, countryMap);
            }
        }
        visited.remove(current);

        return totalFound;
    }

    private static int findRoutes(int rootCity, TreeMap<Integer, List<Integer>> countryMap, Map<Integer, Integer> checkedRoutes) {
        if (checkedRoutes.containsKey(rootCity)) return checkedRoutes.get(rootCity);
        int routes = 1;
        for (int neighbor : countryMap.get(rootCity)) {
            routes += findRoutes(neighbor, countryMap, checkedRoutes);
        }
        checkedRoutes.put(rootCity, routes);
        return routes;
    }
}
