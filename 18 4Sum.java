// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
 

// Constraints:

// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
  
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4) return res;

        for(int one = 0; one < nums.length - 3; one++){
            if(one > 0 && nums[one] == nums[one - 1]) 
                continue;

            for(int two = one + 1; two < nums.length - 2; two++){
                if(two != one+1 && nums[two] == nums[two-1])
                    continue;

                int left = two+1;
                int right = nums.length - 1;

                while(left < right){
                    long sum = (long) nums[one] + nums[two] + nums[left] + nums[right];

                    if(sum == target){
                        res.add(Arrays.asList(nums[one], nums[two], nums[left], nums[right]));
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left - 1])
                            left++;
                        while(left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }  
                }
            }        
        }
        return res;
    }
}