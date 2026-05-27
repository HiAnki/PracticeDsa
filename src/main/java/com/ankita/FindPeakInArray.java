package com.ankita;

public class FindPeakInArray {

    //Example 1:
    //
    //Input: nums = [1,2,3,1]
    //Output: 2
    //Explanation: 3 is a peak element and your function should return the index number 2.
    //Example 2:
    //
    //Input: nums = [1,2,1,3,5,6,4]
    //Output: 5
    //Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

    // bruit force sol: log n

    public static void main(String[] args) {
        int[] input = {1,2,1,3,5,6,4};

        int ans = execute(input);

        System.out.println(ans);
    }

    private static int execute(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;   // it could be left or right, the moment the 2 are same we find our answer
    }
}
