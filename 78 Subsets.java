// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(nums, 0, list, subset);

        return subset;
    }
    private static void helper(int[] nums, int idx, List<Integer> list, List<List<Integer>> subset){
        subset.add(new ArrayList<>(list));

        for(int i=idx; i<nums.length; i++){
            list.add(nums[i]);
            helper(nums, i+1, list, subset);
            list.remove(list.size() - 1);
        }
    }
}

class NaiveSolution {
    private static List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        helper(n, new StringBuilder(), res);
        return res;
    }
    private static void helper(int n, StringBuilder bin, List<String> res){
        if(n == bin.length()){
            res.add(bin.toString());
            return;
        }

        helper(n, bin.append("0"), res);    
        bin.deleteCharAt(bin.length() - 1);

        helper(n, bin.append("1"), res);
        bin.deleteCharAt(bin.length() - 1);

        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<String> mask = validStrings(nums.length);

        for(String bits: mask){
            ArrayList<Integer> list  = new ArrayList<>();
            
            for(int i=0; i<bits.length(); i++){
                if(bits.charAt(i) == '1')
                    list.add(nums[i]);
            }

            subset.add(new ArrayList<>(list));
        }
        return subset;
    }
    private static void helper(int[] nums, int idx, List<Integer> list, List<List<Integer>> subset){
        
    }
}