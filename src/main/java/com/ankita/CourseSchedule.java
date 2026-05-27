package com.ankita;

import java.util.*;

public class CourseSchedule {

    // t.c = O(V + E)
    // space = O(V + E)

    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequisites = {{1,0}};

        boolean result = execute(numCourse, prerequisites);
        System.out.println(result);
    }

    private static boolean execute(int numCourse, int[][] prerequisites) {
        List<List<Integer>> adjList = createAdjList(numCourse, prerequisites);
        
        boolean[] visited = new boolean[numCourse];
        boolean[] pathVisited = new boolean[numCourse];
        
//        Stack<Integer> topo = new Stack<>();

        for (int i = 0; i< numCourse; i++) {
            if (!visited[i]) {
               boolean ans = dfs(adjList, visited, pathVisited, i);
               if (!ans) {
                   return ans;
               }
            }
        }


        return true;
    }

    private static boolean dfs(List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited, int source) {

        visited[source] = true;
        pathVisited[source] = true;

        List<Integer> nbrs = adjList.get(source);

        for (int n : nbrs) {
            if (pathVisited[n]) {
                return false;
            }

            if (!visited[n]) {
                boolean ans = dfs(adjList, visited, pathVisited, n);
                if (!ans) {
                    return false;
                }
            }
        }

        pathVisited[source] = false;
        return true;
    }

    private static List<List<Integer>> createAdjList(int numCourse, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i =0; i<numCourse; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0; i<prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            int source = edge[1];
            int des = edge[0];
            adjList.get(source).add(des);
        }

        return adjList;
    }
}
