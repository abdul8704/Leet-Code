// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

// Example 2:
// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

// Constraints:
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= k <= min(50, nums.length)

class Solution {
    public int splitArray(int[] nums, int k) {
        int largest = nums[0], totalSum = nums[0], N = nums.length;

        for(int i=1; i<N; i++){
            largest = Math.max(largest, nums[i]);
            totalSum += nums[i];
        }

        if(k == 1) return totalSum;
        if(k == N) return largest;

        int left = largest, right = totalSum, res = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            int check = tryLimit(nums, N, mid, k);
            
            if(check == -1){
                left = mid + 1;
            }
            else{
                res = Math.min(res, check);
                right = mid - 1;
            }
        }

        return res;
    }
    private static int tryLimit(int[] nums, int N, int limit, int k){
        int groups = 1, sum = 0, maxSum = 0;

        for(int i=0; i<N; i++){
            if(sum + nums[i] <= limit){
                sum += nums[i];
            }
            else{
                groups++; if(groups > k) return -1;
                maxSum = Math.max(maxSum, sum);
                sum = nums[i];
            }
        }

        return Math.max(maxSum, sum);
    }
}

class OptimisedSolution{
    public int splitArray(int[] nums, int k) {
        int largest = nums[0], totalSum = nums[0], N = nums.length;

        for(int i=1; i<N; i++){
            largest = Math.max(largest, nums[i]);
            totalSum += nums[i];
        }

        if(k == 1) return totalSum;
        if(k == N) return largest;

        int left = largest, right = totalSum, res = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;

            if(tryLimit(nums, N, mid, k)){
                right = mid - 1;
            }
            else{
                left = mid + 1; 
            }
        }

        return left;
    }
    private static boolean tryLimit(int[] nums, int N, int limit, int k){
        int groups = 1, sum = 0;

        for(int i=0; i<N; i++){
            if(sum + nums[i] <= limit){
                sum += nums[i];
            }
            else{
                groups++; if(groups > k) return false;
                sum = nums[i];
            }
        }

        return true;
    }
}