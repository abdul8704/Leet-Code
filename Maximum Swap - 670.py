# You are given an integer num. You can swap two digits at most once to get the maximum valued number.

# Return the maximum valued number you can get.

 

# Example 1:

# Input: num = 2736
# Output: 7236
# Explanation: Swap the number 2 and the number 7.
# Example 2:

# Input: num = 9973
# Output: 9973
# Explanation: No swap.
 

# Constraints:

# 0 <= num <= 108

class Solution(object):
    def maximumSwap(self, num):
        arr = [int(i) for i in str(num)]
        hashmap = {}
        for i in range(len(arr)):
            hashmap[arr[i]] = i
        
        for i in range(len(arr)):
            for digit in range(9,arr[i],-1):
                if digit in hashmap and hashmap[digit] > i:
                    arr[i], arr[hashmap[digit]] = arr[hashmap[digit]], arr[i]
                    res=''.join(str(i) for i in arr)
                    return int(res)
        return num    
print(19%10)    