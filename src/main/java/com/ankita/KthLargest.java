package com.ankita;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        // Example 1:
        //
        //Input: nums = [3,2,1,5,6,4], k = 2
        //Output: 5
        //Example 2:
        //
        //Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        //Output: 4

        // bruit force: intuitive: sort the array, get kth element from the end non duplicate nlog(n)
        //

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(execute(nums, k));

    }

    private static Object execute(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
