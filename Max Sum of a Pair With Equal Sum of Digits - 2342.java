// You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

// Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.


// Example 1:
// Input: nums = [18,43,36,13,7]
// Output: 54
// Explanation: The pairs (i, j) that satisfy the conditions are:
// - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
// - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
// So the maximum sum that we can obtain is 54.

// Example 2:
// Input: nums = [10,12,19,14]
// Output: -1
// Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 
// Constraints:
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109

import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        int[] map = new int[82];    // as per constraints, largest sum of digits will be sumOfDigits(10^9 - 1) = 81.
        int res = -1;

        for(int i=0; i<nums.length; i++){
            int comp = sumOfDigits(nums[i]);    //find sum of digits of current number
            
            if(map[comp] > 0)                   //check if it theres a number with this sum.
                res = Math.max(res, nums[i] + map[comp]);      //self explanatory

            map[comp] = Math.max(map[comp], nums[i]);    //make sure we consider the greater number with a ceratin sum.
        }

        return res;
    }
    
    private static int sumOfDigits(int n){
        int sum = 0;
        while(n != 0){
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}

class BruteForceSolution {
    private static int sumOfDigits(int n){
        int sum = 0;

        while(n != 0){
            sum += (n % 10);
            n /= 10;
        }

        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int res = -1;

        for(int i=0; i<nums.length; i++){
            int comp = sumOfDigits(nums[i]);

            if(hash.containsKey(comp)){
                
                res = Math.max(res, nums[i]+ hash.get(comp));
                hash.put(comp, Math.max(nums[i], hash.get(comp)));
                System.out.println(nums[i] + " " + hash.get(comp));
            }
            else{
                hash.put(comp, nums[i]);
            }
        }
        return res;
    }
}