// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// Example 2:
// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 
// Constraints:
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, list, res);

        return res;
    }
    private static void helper(int[] arr, int target, int idx, int sum, List<Integer> list, List<List<Integer>> res){
        if(sum == target){
            res.add(list);
            return;
        }
        if(sum > target || idx >= arr.length)
            return;

        for(int i=idx; i<arr.length; i++){
            if(i > idx && arr[i] == arr[i-1])
                continue;

            if(arr[i] > target-sum)
                break;    

            list.add(arr[i]);
            helper(arr, target, i+1, sum + arr[i], new ArrayList(list), res);    
            list.remove(list.size() - 1);
        }

    }
}