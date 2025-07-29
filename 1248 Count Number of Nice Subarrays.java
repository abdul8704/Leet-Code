// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
// Return the number of nice sub-arrays.

// Example 1:
// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

// Example 2:
// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There are no odd numbers in the array.

// Example 3:
// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16
 
// Constraints:
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int N = nums.length, oddCount = 0, res = 0;

        for(int num: nums){
            if(num % 2 == 1)
                oddCount++;

            if(oddCount == k)
                res++;

            if(map.containsKey(oddCount - k))
                res += map.get(oddCount - k);    

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);    
        }

        return res;
    }
}