# Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

# Notice that the solution set must not contain duplicate triplets.

# Example 1:

# Input: nums = [-1,0,1,2,-1,-4]
# Output: [[-1,-1,2],[-1,0,1]]
# Explanation: 
# nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
# nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
# nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
# The distinct triplets are [-1,0,1] and [-1,-1,2].
# Notice that the order of the output and the order of the triplets does not matter.
# Example 2:

# Input: nums = [0,1,1]
# Output: []
# Explanation: The only possible triplet does not sum up to 0.
# Example 3:

# Input: nums = [0,0,0]
# Output: [[0,0,0]]
# Explanation: The only possible triplet sums up to 0.
 

# Constraints:

# 3 <= nums.length <= 3000
# -105 <= nums[i] <= 105

class Solution(object):
    def threeSum(self, nums): #optimised 2 pointer soln
        res = []
        nums.sort()

        for current in range(len(nums)):
            if current > 0 and nums[current] == nums[current - 1]:
                continue

            left = current + 1
            right = len(nums) - 1

            while left < right:
                total = nums[left] + nums[right] + nums[current]
                if total == 0:
                    res.append([nums[current], nums[left], nums[right]])

                    left += 1
                    right -= 1
                    while nums[left] == nums[left - 1] and left < right:
                        left += 1
                    while  left < right and nums[right] == nums[right + 1] :
                        right -= 1    

                elif total > 0:
                    right -= 1

                else:
                    left += 1           
        return res            

class Solution(object):
    def threeSum(self, nums): #brute force soln
        res = []
        nums.sort()
        current = 0
        hash = {}

        while current < len(nums) - 2:
            left = current + 1
            right = len(nums) - 1

            while(left < right):
                if nums[left] + nums[right] == -1 * nums[current]:
                    ans = tuple([nums[current], nums[left], nums[right]])
                    if ans not in hash:
                        res.append(ans)
                        hash[ans] = 1
                    left += 1
                    right -= 1

                elif nums[left] + nums[right] > -1 * nums[current]:
                    right -= 1

                else:
                    left += 1
            current += 1
        return res            
