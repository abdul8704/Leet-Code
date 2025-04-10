# A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:

# 't' that evaluates to true.
# 'f' that evaluates to false.
# '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
# '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
# '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
# Given a string expression that represents a boolean expression, return the evaluation of that expression.

# It is guaranteed that the given expression is valid and follows the given rules.

 

# Example 1:

# Input: expression = "&(|(f))"
# Output: false
# Explanation: 
# First, evaluate |(f) --> f. The expression is now "&(f)".
# Then, evaluate &(f) --> f. The expression is now "f".
# Finally, return false.
# Example 2:

# Input: expression = "|(f,f,f,t)"
# Output: true
# Explanation: The evaluation of (false OR false OR false OR true) is true.
# Example 3:

# Input: expression = "!(&(f,t))"
# Output: true
# Explanation: 
# First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
# Then, evaluate !(f) --> NOT false --> true. We return true.
 

# Constraints:

# 1 <= expression.length <= 2 * 104
# expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.

class Solution(object):  
    def parseBoolExpr(self, expression):
        operator = []       #stack that will have operators(!, |, &)
        operand = []        #stack that will have operands(true, false, "(", ")")
        ans = None

        for i in expression:
            if i == '(' or i == 't' or i == 'f' :
                operand.append(i)
            elif i == '&' or i == '|' or i == '!':
                operator.append(i)
            elif i == ')':
                op = operator.pop()

                if op == '&' :
                    ans = True                          #for AND, start with TRUE
                    while operand[-1] != '(':
                        ans &= (operand[-1] == 't')
                        operand.pop()
                elif op == '|':                        #for OR, start with FALSE
                    ans = False
                    while operand[-1] != '(':
                        ans |= (operand[-1] == 't')
                        operand.pop()
                else:                               #NOT will have only operand,so no need loop
                    ans = not (operand[-1] == 't')
                    operand.pop()
                
                operand.pop() # to pop '('
                if ans:       #push the result boolean value
                    operand.append('t') 
                else:
                    operand.append('f')                         
                  
        return ans               
"""reference from https://www.youtube.com/watch?v=klYVViIowm8 """

        