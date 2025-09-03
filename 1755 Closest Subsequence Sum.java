// You are given an integer array nums and an integer goal.
// You want to choose a subsequence of nums such that the sum of its elements is the closest possible to goal. That is, if the sum of the subsequence's elements is sum, then you want to minimize the absolute difference abs(sum - goal).
// Return the minimum possible value of abs(sum - goal).
// Note that a subsequence of an array is an array formed by removing some elements (possibly all or none) of the original array.

// Example 1
// Input: nums = [5,-7,3,5], goal = 6
// Output: 0
// Explanation: Choose the whole array as a subsequence, with a sum of 6.
// This is equal to the goal, so the absolute difference is 0.

// Example 2:
// Input: nums = [7,-9,15,-2], goal = -5
// Output: 1
// Explanation: Choose the subsequence [7,-9,-2], with a sum of -4.
// The absolute difference is abs(-4 - (-5)) = abs(1) = 1, which is the minimum.

// Example 3:
// Input: nums = [1,2,3], goal = -7
// Output: 7
 
// Constraints:
// 1 <= nums.length <= 40
// -107 <= nums[i] <= 107
// -109 <= goal <= 109

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int N = nums.length;
        List<Integer> A = subSum(nums, 0, N / 2);
        List<Integer> B = subSum(nums, N / 2, N);

        Collections.sort(B);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            int rem = goal - A.get(i);
            int l = upperBound(B, rem);
            
            min = Math.min(min, Math.abs(goal - (A.get(i) + B.get(l))));

            if (l + 1 < B.size()) {
                min = Math.min(min, Math.abs(goal - (A.get(i) + B.get(l + 1))));
            }
        }

        return min;
    }

    private static List<Integer> subSum(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<>();
        dfs(arr, start, end, 0, list);
        return list;
    }

    private static void dfs(int[] arr, int idx, int N, int sum, List<Integer> l) {
        if (idx == N) {
            l.add(sum);
            return;
        }

        dfs(arr, idx + 1, N, sum, l);
        dfs(arr, idx + 1, N, sum + arr[idx], l);
        return;
    }

    private static int upperBound(List<Integer> A, int target) {
        int l = 0, r = A.size() - 1;

        while (l <= r) {
            int m = (r - l) / 2 + l;

            if (A.get(m) > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return (r == -1) ? 0 : r;
    }

}


class Solution2 {
    public int minAbsDifference(int[] nums, int goal) {
        int N = nums.length;
        List<Integer> A = subSum(nums, 0, N/2);
        List<Integer> B = subSum(nums, N/2, N);

        Collections.sort(B);

        // System.out.println(A);
        // System.out.println(B);


        int min = Integer.MAX_VALUE;

        for(int i=0; i<A.size(); i++){
            int rem = goal - A.get(i);
            int l = lowerBound(B, rem);
        // System.out.println(i + " " + l +" " + A.size() + " " + B.size());
            min = Math.min(min, Math.abs(goal - (A.get(i) + B.get(l))));
            if (l > 0) {
    min = Math.min(min, Math.abs(goal - (A.get(i) + B.get(l-1))));
}
        }

        return min;
    }
    private static List<Integer> subSum(int[] arr, int start, int end){
        List<Integer> list = new ArrayList<>();
        dfs(arr, start, end, 0, list);  
        return list;      
    }
    private static void dfs(int[] arr, int idx, int N, int sum ,List<Integer> l){
        if(idx == N){
            l.add(sum);
            return;
        }

        dfs(arr, idx+1, N, sum, l);
        dfs(arr, idx+1, N, sum + arr[idx], l);
        return;
    }
    private static int lowerBound(List<Integer> A, int target){
        int l = 0, r = A.size() - 1;

        while(l <= r){
            int m = (r - l) / 2 + l;

            if(A.get(m) >= target){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }

        return (l == A.size()) ? l-1: l;
    }
    
}