// same as https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1

// You are given an integer array nums and an integer target.
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

 

// Example 1:
// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

// Example 2:
// Input: nums = [1], target = 1
// Output: 1
 
// Constraints:
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000

class Solution { // O(N*target) time and space
    public int findTargetSumWays(int[] nums, int d) {
        int totalSum = 0, N = nums.length;
        d = Math.abs(d);

        for(int num:nums)
            totalSum += num;
        
        if((d + totalSum) % 2==1)
            return 0;
        
        int target = (d + totalSum) / 2;

        int[][] dp = new int[N][target+1];

        for(int i=0; i<N;i++)
            dp[i][0] = 1;

        if(nums[0] == 0)
            dp[0][nums[0]] = 2;
        else if(nums[0] <= target)
            dp[0][nums[0]] = 1;

        for(int i=1; i<N; i++){
            for(int tar=0; tar <= target; tar++){
                dp[i][tar] = dp[i-1][tar];

                if(tar - nums[i] >= 0)
                    dp[i][tar] += dp[i-1][tar - nums[i]];
            }
        }

        return dp[N-1][target];
    } 
}

class Solution2 { // O(N*target) time and O(target) space
    public int findTargetSumWays(int[] nums, int d) {
        int totalSum = 0, N = nums.length;
        d = Math.abs(d);

        for(int num:nums)
            totalSum += num;
        
        if((d + totalSum) % 2==1)
            return 0;
        
        int target = (d + totalSum) / 2;

        int[] dp = new int[target+1];

        if(nums[0] == 0)
            dp[0] = 2;
        else if(nums[0] <= target){
            dp[0] = 1;
            dp[nums[0]] = 1;
        }

        for(int i=1; i<N; i++){
            for(int tar=target; tar >= nums[i]; tar--){
                dp[tar] += dp[tar - nums[i]];
            }
        }
        return dp[target];
    } 
}