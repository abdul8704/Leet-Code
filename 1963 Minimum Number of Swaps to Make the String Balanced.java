// You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
// A string is called balanced if and only if:

// It is the empty string, or
// It can be written as AB, where both A and B are balanced strings, or
// It can be written as [C], where C is a balanced string.
// You may swap the brackets at any two indices any number of times.

// Return the minimum number of swaps to make s balanced.
// Example 1:

// Input: s = "][]["
// Output: 1
// Explanation: You can make the string balanced by swapping index 0 with index 3.
// The resulting string is "[[]]".
// Example 2:

// Input: s = "]]][[["
// Output: 2
// Explanation: You can do the following to make the string balanced:
// - Swap index 0 with index 4. s = "[]][][".
// - Swap index 1 with index 5. s = "[[][]]".
// The resulting string is "[[][]]".
// Example 3:

// Input: s = "[]"
// Output: 0
// Explanation: The string is already balanced.
 

// Constraints:

// n == s.length
// 2 <= n <= 106
// n is even.
// s[i] is either '[' or ']'.
// The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2. -->

import java.util.Stack;

class Solution {
    public int minSwaps(String s) {     //linear space complexity
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '['){
                stack.push('[');
            }
            else{
                if(stack.isEmpty()){
                    unbalanced++;
                }
                else{
                    stack.pop();
                }
            }
        }
        return (unbalanced + 1)/2;
    }
    public int minSwaps1(String s) {  //simulate a stack
        int stack = 0, unbalanced = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '['){
                stack++;
            }
            else{
                if(stack == 0){
                    unbalanced++;
                }
                else{
                    stack--;
                }
            }
        }
        return (unbalanced + 1)/2;
    }
    public int minSwaps2(String s) { //constamt space
        int i = 0;

        for(int j=0; j<s.length(); j++){
            if(s.charAt(j) == '['){
                i++;
            }
            else if(i > 0){
                i--;
            }
        }
        return (i + 1)/2;
    }
}