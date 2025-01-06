# A fancy string is a string where no three consecutive characters are equal.

# Given a string s, delete the minimum possible number of characters from s to make it fancy.

# Return the final string after the deletion. It can be shown that the answer will always be unique.

 

# Example 1:

# Input: s = "leeetcode"
# Output: "leetcode"
# Explanation:
# Remove an 'e' from the first group of 'e's to create "leetcode".
# No three consecutive characters are equal, so return "leetcode".
# Example 2:

# Input: s = "aaabaaaa"
# Output: "aabaa"
# Explanation:
# Remove an 'a' from the first group of 'a's to create "aabaaaa".
# Remove two 'a's from the second group of 'a's to create "aabaa".
# No three consecutive characters are equal, so return "aabaa".
# Example 3:

# Input: s = "aab"
# Output: "aab"
# Explanation: No three consecutive characters are equal, so return "aab".
 

# Constraints:

# 1 <= s.length <= 105
# s consists only of lowercase English letters.


# Space optimum solution ->
class Solution(object):
    def makeFancyString(self, s):
        res = ""
        for ch in s:
            if len(res) < 2:
                res += ch
            else:
                if ch == res[-1] and ch == res[-2]:
                    continue
                else:
                    res += ch    
        return res
#can use array instead of string to make it faster
class Solution(object):
    def makeFancyString(self, s):
        res = []
        for ch in s:
            if len(res) < 2:
                res.append(ch)
            else:
                if ch == res[-1] and ch == res[-2]:
                    continue
                else:
                    res.append(ch)    
        return ''.join(res)            

#my initial brute force soln
class Solution(object):
    def makeFancyString(self, s):
        s = [i for i in s]
        i = len(s) - 1
        try:
            while i >= 2:
                if  s[i] == s[i-1] and s[i-1] == s[i-2]:
                    del s[i]
                i -=1
            return "".join(s) 
        except IndexError:
            print(i) 
            print(s)          
                


        