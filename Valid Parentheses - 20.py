'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
'''
def isValid(self, s: str) -> bool:
        stack = []
        hashMap = {')':'(', '}' : '{', ']' : '['}

        for i in s:
            if i in hashMap and stack :     #"if stack" returns true if the stack is NOT EMPTY. "if stack" return false in case, stack is empty
                if stack[-1] == hashMap[i]:
                    stack.pop()
                else:
                    return False    
            else:
                stack.append(i)     

        return not stack        #returns true if the stack is empty

# time complexity : O(n)

    
"""
first we are creating hash-map for closing brackets to their appropriate opening brackets. (because its easier to find )
the main implementation is STACK.
The main idea is that, if we see a opening bracket, we push it to stack. 
if we see a closing bracket, and if the top of the stack is the appropriate opener, we pop it since its valid.   valid-> ([])
if the closing bracket is not corresponding closer of the top element in stack, we return false. invalid -> [(])

finally we traverse the string. and find result"""    