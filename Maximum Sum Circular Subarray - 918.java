// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 // Example 1:

// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.

// Example 2:

// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

// Example 3:

// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.
 
// Constraints:
// n == nums.length
// 1 <= n <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;     //find total sum of array

        int temp_min = 0, min_sub = 30001;  //finding max subarray(kadane's algo)
        int temp_max = 0, max_sub = -30001; //finding min subarray(kadane's algo)

        for(int num:nums){
            sum += num;

            temp_min += num;
            temp_max += num;

            min_sub = Math.min(min_sub, temp_min);
            max_sub = Math.max(max_sub, temp_max);

            temp_max = (temp_max < 0)? 0:temp_max;
            temp_min = (temp_min > 0)? 0:temp_min;
        }
        if(sum == min_sub){        // if this case is true, all elements in array in negative, so return the max element
            return max_sub;
        }
        return Math.max(sum - min_sub, max_sub);    //else compare bw max subarray and max sum without min subarray
    }
}