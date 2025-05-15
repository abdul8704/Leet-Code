// A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
// For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
// A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
// Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
// Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

// Example 1:
// Input: s = "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

// Example 2:
// Input: s = "(()())(())(()(()))"
// Output: "()()()()(())"
// Explanation: 
// The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
// After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

// Example 3:
// Input: s = "()()"
// Output: ""
// Explanation: 
// The input string is "()()", with primitive decomposition "()" + "()".
// After removing outer parentheses of each part, this is "" + "" = "".
 
// Constraints:
// 1 <= s.length <= 105
// s[i] is either '(' or ')'.
// s is a valid parentheses string.

import java.util.Stack;

class OptimisedSolution {
    public String removeOuterParentheses(String s) {
        int stack = 0;
        StringBuilder res = new StringBuilder(); 
        boolean first = true;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                if(first)
                    first = false;
                else{
                    stack++;
                    res.append('(');
                }    
            }
            else{
                if(stack == 0)
                    first = true;
                else{
                    stack--;
                    res.append(')');
                } 
            }
        }

        return res.toString();
    }
}

class BruteForceSolution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        String res = new String(); boolean first = true;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                if(first)
                    first = false;
                else{
                    stack.push('(');
                    res += "(";
                }    
            }
            else{
                if(stack.isEmpty())
                    first = true;
                else{
                    stack.pop();
                    res += ")";
                } 
            }
        }

        return res;
    }
}