# Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

# The value of |x| is defined as:

# x if x >= 0.
# -x if x < 0.
 

# Example 1:

# Input: nums = [1,2,2,1], k = 1
# Output: 4
# Explanation: The pairs with an absolute difference of 1 are:
# - [1,2,2,1]
# - [1,2,2,1]
# - [1,2,2,1]
# - [1,2,2,1]
# Example 2:

# Input: nums = [1,3], k = 3
# Output: 0
# Explanation: There are no pairs with an absolute difference of 3.
# Example 3:

# Input: nums = [3,2,1,5,4], k = 2
# Output: 3
# Explanation: The pairs with an absolute difference of 2 are:
# - [3,2,1,5,4]
# - [3,2,1,5,4]
# - [3,2,1,5,4]
 

# Constraints:

# 1 <= nums.length <= 200
# 1 <= nums[i] <= 100
# 1 <= k <= 99

class Solution(object):
    def countKDifference(self, nums, k):
        hashmap = {}
        ans = 0
        # |nums[i] - nums[j]| == k can be written as nums[i] - nums[j] = |k|
        #     therefore, we need to find cases where nums[i] - nums[j] == k  (i.e) nums[j] = nums[i] - k
        #                                  and where nums[i] - nums[j] == -k (i.e) nums[j] = nums[i] + k

        for i in range(len(nums)):
            if nums[i] - k in hashmap:
                ans += hashmap[nums[i] - k]         #increment ans with the number of times the complement exists

            if nums[i] + k in hashmap:
                ans += hashmap[nums[i] + k]

            if nums[i] in hashmap:
                hashmap[nums[i]] += 1

            else:
                hashmap[nums[i]] = 1

        return ans