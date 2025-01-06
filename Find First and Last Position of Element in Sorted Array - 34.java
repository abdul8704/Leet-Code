// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 
// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        int res[] = {-1, -1};
        
        if(nums.length == 0) return res;
        
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                break;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        if(nums[mid] != target){
            return res;
        }
        int i = mid;
        
        while(i >= 0 && i < nums.length && nums[i] == target){
            i--;
        }
        while(mid >= 0 && mid < nums.length && nums[mid] == target){
            mid++;
        }
        res[0] = i + 1;
        res[1] = mid - 1;

        return res;
    }
}