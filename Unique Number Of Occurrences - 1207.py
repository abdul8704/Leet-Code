# Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

# Example 1:

# Input: arr = [1,2,2,1,1,3]
# Output: true
# Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
# Example 2:

# Input: arr = [1,2]
# Output: false
# Example 3:

# Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
# Output: true
 

# Constraints:

# 1 <= arr.length <= 1000
# -1000 <= arr[i] <= 1000

class Solution(object):
    def uniqueOccurrences(self, arr):
        hashmap = {}
        set1 = set(arr) #using set
        set2 = set()

        for i in arr:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1

        set2 = set(hashmap.values())

        return len(set1) == len(set2)   
    
#using two hashmaps        
class Solution(object):
    def uniqueOccurrences(self, arr):
        hashmap1 ={}
        for i in arr:
            if i in hashmap1:
                hashmap1[i] += 1
            else:
                hashmap1[i] = 1    
        hashmap2 = {}
        nums = hashmap1.values()
        print(nums)
        for i in nums:
            if i in hashmap2:
                hashmap2[i] += 1
                if hashmap2[i] > 1 : 
                    return False
                    
            else:
                hashmap2[i] = 1
        return True      