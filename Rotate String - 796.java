// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.

// Example 1:
// Input: s = "abcde", goal = "cdeab"
// Output: true

// Example 2:
// Input: s = "abcde", goal = "abced"
// Output: false
 
// Constraints:

// 1 <= s.length, goal.length <= 100
// s and goal consist of lowercase English letters.

class Solution {     //concatenate string s with itself and implement kmp algorithm to find pattern
    static int[] constructLPS(String pat){  
        int lps[] = new int[pat.length()];      //constructing lps array
        lps[0] = 0;
        
        int i = 1,length = 0;
        
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            }
            else if(length != 0){
                length = lps[length - 1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal))
            return true;
        if(s.length() != goal.length())
            return false;
            
        String str = s + s;
        
        int[] lps = constructLPS(goal);
        
        int i = 0, j = 0;
        while(i < str.length()){                //implementing kmp algorithm to find goal string
            if(str.charAt(i) == goal.charAt(j)){
                i++;
                j++;
                
                if(j == goal.length()){
                    return true;
                }
            }
            else if(j != 0){
                j = lps[j-1];
            }
            else{
                i++;
            }
        }
        return false;
        
    }   
}
