// You are given a positive integer n.
// A binary string x is valid if all substrings of x of length 2 contain at least one "1".
// Return all valid strings with length n, in any order.

// Example 1:
// Input: n = 3
// Output: ["010","011","101","110","111"]
// Explanation:
// The valid strings of length 3 are: "010", "011", "101", "110", and "111".

// Example 2:
// Input: n = 1
// Output: ["0","1"]
// Explanation:
// The valid strings of length 1 are: "0" and "1".

// Constraints:
// 1 <= n <= 18

class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        helper(n, new StringBuilder(), res);
        return res;
    }
    private static void helper(int n, StringBuilder bin, List<String> res){
        if(n == bin.length()){
            res.add(bin.toString());
            return;
        }

        int last = bin.length() - 1;

        if(last >= 0){
            helper(n, bin.append("1"), res);
            bin.deleteCharAt(bin.length() - 1);

            if(bin.charAt(last) != '0'){
                helper(n, bin.append("0"), res);    
                bin.deleteCharAt(bin.length() - 1);
            }
        }
        else{
            helper(n, bin.append("0"), res);
            bin.deleteCharAt(bin.length() - 1);

            helper(n, bin.append("1"), res);  
            bin.deleteCharAt(bin.length() - 1);

        }

        return;
    }
}