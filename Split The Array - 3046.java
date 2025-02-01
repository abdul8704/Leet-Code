// You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:

// nums1.length == nums2.length == nums.length / 2.
// nums1 should contain distinct elements.
// nums2 should also contain distinct elements.
// Return true if it is possible to split the array, and false otherwise.

 

// Example 1:

// Input: nums = [1,1,2,2,3,4]
// Output: true
// Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].
// Example 2:

// Input: nums = [1,1,1,1]
// Output: false
// Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain distinct elements. Therefore, we return false.
 

// Constraints:

// 1 <= nums.length <= 100
// nums.length % 2 == 0 
// 1 <= nums[i] <= 100

import java.util.HashMap;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();       //use a hashmap to keep count of occurence of each element

        for(int i:nums){
            hash.put(i,hash.getOrDefault(i,0)+1);               //if i exists, increment it's value, else create a new ky-value pair
            if( hash.get(i) > 2){                               // if an element occurs thrice, it's impossible to split the array as per conditions.
                return false;
            }
        }
        return true;
    }
}

// 1 <= nums[i] <= 100 
// i didnt read the question properly..so i missed this constraint...instead of a hashmap we can just use an array of 101 size 

class Solution1 {
    public boolean isPossibleToSplit(int[] nums) {
        int[] counter = new int[101];

        for(int i: nums){           //index of the array will act as key, and value will keep track of occurence
            counter[i] += 1;
            if(counter[i] > 2) return false;
        } 
        return true;
    }
}
