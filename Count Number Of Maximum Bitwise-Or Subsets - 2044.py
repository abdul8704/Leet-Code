# Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

# An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

# The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).

 

# Example 1:

# Input: nums = [3,1]
# Output: 2
# Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
# - [3]
# - [3,1]
# Example 2:

# Input: nums = [2,2,2]
# Output: 7
# Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
# Example 3:

# Input: nums = [3,2,1,5]
# Output: 6
# Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
# - [3,5]
# - [3,1,5]
# - [3,2,5]
# - [3,2,1,5]
# - [2,5]
# - [2,1,5]
 

# Constraints:

# 1 <= nums.length <= 16
# 1 <= nums[i] <= 105

class Solution(object):
    def countMaxOrSubsets(self, nums):
        max_or = 0
        for i in nums:
            max_or |= i
        count = 0
        n = 1 << len(nums)

        for i in range(n):
            current_or = 0
            for j in range(len(nums)):
                if (i >> j) & 1 :
                    current_or |= nums[j]
            if current_or == max_or:
                count +=1        

        return count   
    
class Solution:
    def countMaxOrSubsets(self, nums: list[int]) -> int:
        max_or_value = 0
        dp = [0] * (1 << 17)

        # Initialize the empty subset
        dp[0] = 1

        # Iterate through each number in the input array
        for num in nums:
            for i in range(max_or_value, -1, -1):
                # For each existing subset, create a new subset by including the current number
                dp[i | num] += dp[i]

            # Update the maximum OR value
            max_or_value |= num

        return dp[max_or_value]
from collections import defaultdict    
class Solution(object):
    def countMaxOrSubsets(self, nums):
        hashmap = defaultdict(int)
        for i in nums:
            temp = dict(hashmap)
            for j in temp:
                hashmap[j|i] += temp[j]
            hashmap[i] += 1
        
        return hashmap[max(hashmap.keys())]    