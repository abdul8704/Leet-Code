# You are given a string number representing a positive integer and a character digit.

# Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in number.

# Example 1:

# Input: number = "123", digit = "3"
# Output: "12"
# Explanation: There is only one '3' in "123". After removing '3', the result is "12".
# Example 2:

# Input: number = "1231", digit = "1"
# Output: "231"
# Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
# Since 231 > 123, we return "231".
# Example 3:

# Input: number = "551", digit = "5"
# Output: "51"
# Explanation: We can remove either the first or second '5' from "551".
# Both result in the string "51".
 

# Constraints:

# 2 <= number.length <= 100
# number consists of digits from '1' to '9'.
# digit is a digit from '1' to '9'.
# digit occurs at least once in number.

class Solution(object):         #linear time complexity, constant space complexity
    def removeDigit(self, number, digit):
        
        for i in range(len(number)):
            if number[i] == digit:
                idx = i             #possible element to remove
                if i < len(number)-1 and digit < number[i+1]:
                    return (number[:i] + number[i+1 :])
                
        return number[:idx] + number[idx+1:]       
        

class Solution(object):
    def removeDigit(self, number, digit):
        res = []
        
        for i in range(len(number)):
            if number[i] == digit:
                res.append(number[:i] + number[i + 1:])
        
        return max(res)        
        
class Solution(object): #brute-force solution. I didn't know the max function in python can do integer comparison with strings
    def toNum(self, arr):
        res = 0
        for i in arr:
            res = (res * 10) + i
        return res

    def removeDigit(self, number, digit):
        
        num = [int(i) for i in number]
        digit = int(digit)

        res = -1 
        for i in range(len(num)):
            if num[i] == digit:
                x = self.toNum(num[:i] + num[i + 1:])
                if res < x:
                    res = x

        return str(res)            