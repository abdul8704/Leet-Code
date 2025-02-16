// Given an array of integers nums, return the number of good pairs.

// A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 

// Example 1:

// Input: nums = [1,2,3,1,1,3]
// Output: 4
// Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
// Example 2:

// Input: nums = [1,1,1,1]
// Output: 6
// Explanation: Each pair in the array are good.
// Example 3:

// Input: nums = [1,2,3]
// Output: 0
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int pairs = 0,appears = 0;

        for(int num : nums){
            appears = hash.getOrDefault(num, 0);
            pairs += appears;
            hash.put(num, appears + 1);

        }
        return pairs;
    }
}   

class OptimisedSolution {
    public int numIdenticalPairs(int[] nums) {
        int map[] = new int[101];
        int res = 0;

        for(int num:nums){
            res += map[num]++;
        }
        return res;
    }
}