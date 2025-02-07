// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

// Example 1:

// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
// Example 2:

// Input: nums = [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);

        int count = 0;
        int maxLen = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            }else{
                count--;
            }

            if(hash.containsKey(count)){
                maxLen = Math.max(maxLen, i - hash.get(count));
            }
            else{
                hash.put(count, i);
            }
        }

        return maxLen;
    }
}