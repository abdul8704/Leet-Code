// You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:

// Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
// Remove the last element from the current array nums.
// Return an array answer, where answer[i] is the answer to the ith query.

 

// Example 1:

// Input: nums = [0,1,1,3], maximumBit = 2
// Output: [0,3,2,3]
// Explanation: The queries are answered as follows:
// 1st query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
// 2nd query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
// 3rd query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
// 4th query: nums = [0], k = 3 since 0 XOR 3 = 3.
// Example 2:

// Input: nums = [2,3,4,7], maximumBit = 3
// Output: [5,2,6,5]
// Explanation: The queries are answered as follows:
// 1st query: nums = [2,3,4,7], k = 5 since 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7.
// 2nd query: nums = [2,3,4], k = 2 since 2 XOR 3 XOR 4 XOR 2 = 7.
// 3rd query: nums = [2,3], k = 6 since 2 XOR 3 XOR 6 = 7.
// 4th query: nums = [2], k = 5 since 2 XOR 5 = 7.
// Example 3:

// Input: nums = [0,1,2,2,5,7], maximumBit = 3
// Output: [4,3,6,4,6,7]
 

// Constraints:

// nums.length == n
// 1 <= n <= 105
// 1 <= maximumBit <= 20
// 0 <= nums[i] < 2maximumBit
// nums​​​ is sorted in ascending order.


class Solution {        //the value for k at each iteration can be found out by toggling all the bits of the current_xor value.
    public int[] getMaximumXor(int[] nums, int maximumBit) {
         //the value for k at each iteration can be found out by toggling all the bits of the current_xor value.
         // if arr is [2,3,4,7], its current xor is 2. max value for k, such that its within the 2^maximimBit (2^3=8) is 5.
         //example if the current_xor is 2 (010), the xor can be maximised by toggling all bits of 2 i.e., (010) ->toggle->(101) i.e., 5
        
         int curr_xor = 0, k = 0;
        int res[] = new int[nums.length];
        int mask = (1 << maximumBit) - 1;   //finds maximum binary number with "n" bits. if n is 3,mask = 111(3), if n is 4,mask is 1111(15).

        for(int num : nums){
            curr_xor ^= num;
        }

        for(int i = 0; i < nums.length;i++){
            
            k = curr_xor ^ mask;                    //maximise k
            res[i] = k;                             //add it to result array
            curr_xor ^= nums[nums.length - i - 1];  //modify curr_xor such that, it's the xor of array with last element removed

        }
        return res;
    }
}