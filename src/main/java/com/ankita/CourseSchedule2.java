package com.ankita;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequisites = {{1,0}};

        int[] result = execute(numCourse, prerequisites);
        System.out.println(result);
    }

    private static int[] execute(int numCourse, int[][] prerequisites) {
        List<List<Integer>> adjList = createAdjList(numCourse, prerequisites);
        int[] indegree = findIndegree(numCourse, adjList);

        Queue<Integer> q = new ArrayDeque();

        for (int i=0; i<numCourse; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[numCourse];
        int count = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            result[count] = current;
            count++;

            List<Integer> nbrs = adjList.get(current);

            for (int val: nbrs) {
                indegree[val]--;
                if (indegree[val] == 0) {
                    q.add(val);
                }
            }
        }

        return numCourse > count ? new int[0] : result;
    }

    private static int[] findIndegree(int numCourse, List<List<Integer>> adjList) {
        // t.c = number of edges
        // space = number of vertices
        int[] indegree = new int[numCourse];
        for (int i=0; i<numCourse; i++) {
            List<Integer> nbr = adjList.get(i);
            for (int j: nbr) {
                indegree[j]++;
            }
        }
        return indegree;
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
