// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// Example 2:
// Input: s = "a"
// Output: [["a"]]
 
// Constraints:
// 1 <= s.length <= 16
// s contains only lowercase English letters.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }
    private static void helper(String s, int start, List<String> list, List<List<String>> res){
        if(start >= s.length()){
            res.add(list);
            return;
        }

        for(int end=start; end < s.length(); end++){    
            if(palindrome(s, start, end)){
                list.add(s.substring(start, end+1));
                helper(s, end+1, new ArrayList<>(list), res);
                list.remove(list.size() - 1);
            }
        }
    }
    private static boolean palindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
    
}