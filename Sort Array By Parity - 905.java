// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 5000
// 0 <= nums[i] <= 5000

class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int even = 0, odd = nums.length -1;

        while(even < odd){
            if((nums[even]&1) == 1){
                swap(nums, even, odd);
                odd--;
            }
            else{
                even++;
            }
        }
        return nums;
    }
}