package com.ankita;

import java.util.ArrayList;
import java.util.List;

public class FindPath {
    
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{0,2},{1,2}};
        int source = 0;
        int destination= 2;

        execute(n, edges, source, destination);
    }

    private static void execute(int n, int[][] edges, int source, int destination) {
        // build adjacency list
        List<List<Integer>> adjList = buildAdjList(edges, n);

        boolean hasPath = dfs(adjList, source, destination, new boolean[n]);

        System.out.println(hasPath);

    }

    private static boolean dfs(List<List<Integer>> adjList, int source, int destination, boolean[] booleans) {
        if (source == destination) {
            return true;
        }

        booleans[source] = true;

        for (List<Integer> nbrs: adjList) {
            for (Integer nbr : nbrs) {
                if (!booleans[nbr] && dfs(adjList, nbr, destination, booleans)) {
                    return true;
                }

            }
        }

        return false;
    }

    private static List<List<Integer>> buildAdjList(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
}
