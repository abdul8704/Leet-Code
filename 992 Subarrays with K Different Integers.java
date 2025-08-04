// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

// Example 1:
// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

// Example 2:
// Input: nums = [1,2,1,3,4], k = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 
// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i], k <= nums.length

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return totalFruit(nums, k) - totalFruit(nums, k-1);
    }

    private int totalFruit(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0, N = nums.length;

        for(int right = 0; right<N; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k){
                if(map.get(nums[left]) == 1)
                    map.remove(nums[left]);
                else
                    map.put(nums[left], map.get(nums[left]) - 1);
                left++;        
            }

            count += (right - left + 1);
        }
        return count;
    }
}