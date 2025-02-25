// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]

// Example 2:
// Input: nums = [1]
// Output: [1]

// Example 3:
// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 
// Follow up: Could you solve the problem in linear time and in O(1) space?

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int N = nums.length;
        int count1 = 0, count2 = 0, cand1 = 0, cand2 = 0;
        
        for(int num:nums){
            if(num == cand1)
                count1++;
            else if(num == cand2)
                count2++;
            else if(count1 == 0){
                cand1 = num;
                count1 = 1;
            }          
            else if(count2 == 0){
                cand2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;

        for(int num:nums){
            if(cand1 == num)
                count1++;
            else if(cand2 == num)
                count2++;    
        }

        if(count1 > N/3)
            res.add(cand1);
        if(count2 > N/3)
            res.add(cand2);    

        return res;
    }
}