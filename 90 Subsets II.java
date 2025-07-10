// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
 
// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int idx){
        res.add(list);

        if(idx >= nums.length){
            return;
        }

        for(int i=idx; i< nums.length; i++){
            if(i > idx && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            helper(nums, res, new ArrayList<>(list), i+1);
            list.remove(list.size() - 1);
        }
    }
}