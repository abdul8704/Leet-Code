// Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
// In one move, you can increment or decrement an element of the array by 1.
// Test cases are designed so that the answer will fit in a 32-bit integer.

// Example 1:
// Input: nums = [1,2,3]
// Output: 2
// Explanation:
// Only two moves are needed (remember each move increments or decrements one element):
// [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

// Example 2:
// Input: nums = [1,10,2,9]
// Output: 16
 
// Constraints:
// n == nums.length
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int median = 0, ops = 0;

        if(N % 2 == 1)
            median = nums[N/2];
        else
            median = (nums[N/2] + nums[N/2 -1]) /2;

        for(int num: nums)
            ops += (Math.abs(num - median));
               

        return ops;
    }
}