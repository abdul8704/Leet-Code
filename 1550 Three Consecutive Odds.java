// Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 
// Example 1:
// Input: arr = [2,6,4,1]
// Output: false
// Explanation: There are no three consecutive odds.

// Example 2:
// Input: arr = [1,2,34,3,4,5,7,23,12]
// Output: true
// Explanation: [5,7,23] are three consecutive odds.
 
// Constraints:
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000

class Solution {
    public boolean threeConsecutiveOdds(int[] nums) {
        if(nums.length < 3) return false;

        int count = 0;

        for(int i=0; i<nums.length; i++){
            if((nums[i] & 1) == 1) 
                count++;
            else
                count = 0;    

            if(count == 3)
                return true;
        }

        return false;
        
    }
}

class SlidingWindowSolution {
    public boolean threeConsecutiveOdds(int[] nums) {
        if(nums.length < 3) return false;
        
        int count = 0;
        for(int i=0; i<3; i++){
            if((nums[i] & 1) == 1)  count++;
        }

        if(count == 3)  return true;

        for(int i=0; i<nums.length - 3; i++){
            if((nums[i] & 1) == 1) count--;
            if((nums[i+3] & 1) == 1) count++;

            if(count == 3) return true;
        }

        return false;
        
    }
}