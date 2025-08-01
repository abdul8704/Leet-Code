// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 
// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        
        if(N == 1)
            return nums[0];
        if(N == 2)
            return Math.max(nums[0], nums[1]);

        int last2 = nums[0], last1 = Math.max(nums[0], nums[1]);
        int best = 0;

        for(int i=2; i<N; i++){
            best = Math.max(last2 + nums[i], last1);
            last2 = last1;
            last1 = best;
        }

        return best;
    }
}

class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 1)
            return nums[0];
        if(N == 2)
            return Math.max(nums[0], nums[1]);

        int[] memo = new int[N];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<N; i++){
            memo[i] = Math.max(memo[i-2] + nums[i], memo[i-1]);
        }

        return memo[N-1];
    }
}