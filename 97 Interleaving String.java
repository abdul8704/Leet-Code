// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
// An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.

// Example 1:
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
// Explanation: One way to obtain s3 is:
// Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
// Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
// Since s3 can be obtained by interleaving s1 and s2, we return true.

// Example 2:
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false
// Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.

// Example 3:
// Input: s1 = "", s2 = "", s3 = ""
// Output: true
 
// Constraints:
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1, s2, and s3 consist of lowercase English letters.
 

// Follow up: Could you solve it using only O(s2.length) additional memory space?

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if( s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] visited = new boolean[s1.length()][s2.length()];    

        return helper(s1, s2, s3, 0, 0, 0, visited);    
    }
    private static boolean helper(String s1, String s2, String s3, int p1, int p2, int p3, boolean[][] visited){
        if(p3 == s3.length())
            return true;
        if(p1 == s1.length())
            return s3.substring(p3, s3.length()).equals(s2.substring(p2, s2.length()));
        else if(p2 == s2.length()){
            return s3.substring(p3, s3.length()).equals(s1.substring(p1, s1.length()));
        }

        char ch1 = s1.charAt(p1),
            ch2 = s2.charAt(p2),
            ch3 = s3.charAt(p3);

        if(ch1 == ch2 && ch2 == ch3 && !visited[p1][p2]){
            boolean test = helper(s1, s2, s3, p1+1, p2, p3+1, visited);
            if(test)
                return true;

            visited[p1][p2] = true; 
            return helper(s1, s2, s3, p1, p2 +1, p3 + 1, visited);   
        }      
        else if(ch1 == ch3){
            return helper(s1, s2, s3, p1 + 1, p2, p3+1, visited);
        }
        else if(ch2 == ch3){
            return helper(s1, s2, s3, p1, p2 + 1, p3+1, visited);
        }

        return false;    
    }
}