// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length

class Solution1 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right =0;
        int max_count=0;

        for(right=0; right<nums.length; right++){
            if(nums[right] == 0)
                k--;

            while(k < 0){
                if(nums[left] == 0)
                    k++;

                left++;    
            }    

            max_count = Math.max(max_count, right - left+1);
        }
        return max_count;
    }
}