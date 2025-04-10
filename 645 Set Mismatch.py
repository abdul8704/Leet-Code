"""
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 10^4
1 <= nums[i] <= 10^4
"""
class Solution(object):
    def findErrorNums(self, nums):
        
        n = len(nums)
        hashMap = [0] * (n+1) #create a hashmap from 1 to n+1 and record how many times a number appears
        missing = 0
        appear_twice = 0

        for i in nums:
            hashMap[i] += 1
        
        #find the number that appears twice and the one that doesn't appear

        for i in range(1, n+1):
            if hashMap[i] > 1:
                appear_twice = i
            if hashMap[i] == 0:
                missing = i
                
        return appear_twice,missing 