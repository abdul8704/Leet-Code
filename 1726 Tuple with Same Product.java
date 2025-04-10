// Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.

// Example 1:
// Input: nums = [2,3,4,6]
// Output: 8
// Explanation: There are 8 valid tuples:
// (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
// (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

// Example 2:
// Input: nums = [1,2,4,5,10]
// Output: 16
// Explanation: There are 16 valid tuples:
// (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
// (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
// (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
// (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 
// Constraints:

// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 104
// All elements in nums are distinct.

import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int prod = nums[i] * nums[j];

                hash.put(prod, hash.getOrDefault(prod, 0) + 1);
            }
        }
        // if we have 3 pairs with same product, they can be taken 3 different ways.
        //            4 pairs = 6 different ways
        //            5 pairs = 10 different ways.... 
        //   {this forms a sequence.. => 0, 1, 3, 6, 10, 15, 21, 28} which can be generalised into a arithmetic progression formula.
        
        for(Integer prod: hash.keySet()){
            int pairCount = hash.get(prod);   //number of pairs with "prod" as their product;
            int possileCombinations = (0 + (pairCount - 1) * (pairCount)) / 2;      // a(n) = (a + (n-1)(n)) / 2; first term is 0.

            count += (possileCombinations * 8);     //every squad of numbers can be arranged in 8 diiferent ways.
        }

    
        return count;
    }
}