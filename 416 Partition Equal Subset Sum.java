// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 
// Constraints:
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0, N = nums.length;
        for(int num: nums)
            total += num;
        
        if(total % 2 == 1)
            return false;
        int target = total / 2;
        
        boolean[][] dp = new boolean[N][target + 1];

        for(int i=0; i<N; i++)
            dp[i][0] = true;

        for(int i=1; i<N; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = dp[i-1][j] || (
                    (j - nums[i] < 0) ? false: dp[i-1][j - nums[i]]
                );
            }
        }
        return dp[N-1][total/2];
    }
}

class MemoSolution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums)
            total += num;
        
        if(total % 2 == 1)
            return false;
        
        Boolean[][] memo = new Boolean[nums.length][total/2 + 1];
        return dfs(nums, 0, 0, total, memo);
    }
    private static boolean dfs(int[] nums, int idx, int sum, int total, Boolean[][] memo){
        if(idx == nums.length)
            return sum == total - sum;

        if(memo[idx][sum] != null)
            return memo[idx][sum];

        boolean take = (sum + nums[idx] > total/2) ? false: dfs(nums, idx+1, sum + nums[idx], total, memo);
        boolean notTake = dfs(nums, idx+1, sum, total, memo);

        memo[idx][sum] = take || notTake;
        return take || notTake;
    }
}