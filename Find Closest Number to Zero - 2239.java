// Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.

 

// Example 1:

// Input: nums = [-4,-2,1,4,8]
// Output: 1
// Explanation:
// The distance from -4 to 0 is |-4| = 4.
// The distance from -2 to 0 is |-2| = 2.
// The distance from 1 to 0 is |1| = 1.
// The distance from 4 to 0 is |4| = 4.
// The distance from 8 to 0 is |8| = 8.
// Thus, the closest number to 0 in the array is 1.
// Example 2:

// Input: nums = [2,-1,1]
// Output: 1
// Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 

// Constraints:

// 1 <= n <= 1000
// -105 <= nums[i] <= 105

class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = 100005;
        boolean isNegative = false;
        for(int num : nums){
            if(num == 0){
                return 0;
            }
            else if(num < 0){
                if(Math.abs(num) < ans){
                    ans = Math.abs(num);
                    isNegative = true;
                }
            }
            else{
                if (num <= ans){
                    ans = num;
                    isNegative = false;
                }
            }
        }
        if(isNegative){
            return ans * -1;

        }
        else{
            return ans;
        }
    }
}