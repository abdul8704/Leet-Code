# Given an array nums of size n, return the majority element.

# The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

# Example 1:

# Input: nums = [3,2,3]
# Output: 3
# Example 2:

# Input: nums = [2,2,1,1,1,2,2]
# Output: 2
 

# Constraints:

# n == nums.length
# 1 <= n <= 5 * 104
# -109 <= nums[i] <= 109
 

# Follow-up: Could you solve the problem in linear time and in O(1) space?

#using hashmap...
class Solution(object):
    def majorityElement(self, nums):
        major = {}
        for i in nums:
            if i in major:
                major[i] += 1
            else:
                major[i] = 1

        occurence = 0
        res = 0
        for i in major:
            if major[i] > occurence:
                occurence = major[i]
                res = i

        return res     
    
# Constant space complexity solution, 
class Solution(object):
    def majorityElement(self, nums):
        nums.sort()
        res = nums[0]
        max_count = 1
        curr_count = 1
        prev = nums[0]

        for i in nums[1:]:
            if i == prev:
                curr_count += 1
                
            else:
                if curr_count > max_count : 
                    max_count = curr_count
                    res = prev
                curr_count = 1
                prev = i    
        else:
            if curr_count > max_count:
                res = nums[-1]
        return res                   

#another O(1) space comp i found i solutions...
class Solution:
    def majorityElement(self, nums):
        res = majority = 0
        
        for n in nums:
            if majority == 0:
                res = n
            
            majority += 1 if n == res else -1
        
        return res