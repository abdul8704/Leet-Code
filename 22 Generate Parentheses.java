// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:
// Input: n = 1
// Output: ["()"]
 
// Constraints:
// 1 <= n <= 8

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    private static void helper(List<String> res, StringBuilder s, int open, int close, int n){
        if(open == n && close == n){
            res.add(s.toString());
            return;
        }
        if(open == n){
            helper(res, s.append(')'), open, close+1, n);
            s.deleteCharAt(s.length() - 1);
        }
        else if(open > close){
            helper(res, s.append('('), open+1, close, n);
            s.deleteCharAt(s.length() - 1);

            helper(res, s.append(')'), open, close+1, n);
            s.deleteCharAt(s.length() - 1);
        }
        else{
            helper(res, s.append('('), open+1, close, n);
            s.deleteCharAt(s.length() - 1);
        }

        return;
    }
}