''''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

'''

def longestCommonPrefix(self, strs: list[str]) -> str:
      strs = sorted(strs)
      first = strs[0]
      last = strs[-1]
      ans =""
      i = 0
      n = min(len(first),len(last))
      while i<n :
        if first[i] != last[i]:
            return ans
        
"""
First, sort the array of strings.
then store the first and last string.
if the first and last string have a prefix, so will the middle elements.
store the length of the shorter string, say len
while loop from i=0 to len.
if first[i] != last[i] , return the ans
else, add the first[i] character to result string.
"""        
