// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// countAndSay(1) = "1"
// countAndSay(n) is the run-length encoding of countAndSay(n - 1).
// Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
// Given a positive integer n, return the nth element of the count-and-say sequence.

// Example 1:
// Input: n = 4
// Output: "1211"
// Explanation:
// countAndSay(1) = "1"
// countAndSay(2) = RLE of "1" = "11"
// countAndSay(3) = RLE of "11" = "21"
// countAndSay(4) = RLE of "21" = "1211"

// Example 2:
// Input: n = 1
// Output: "1"
// Explanation:
// This is the base case.

// Constraints:
// 1 <= n <= 30
 
// Follow up: Could you solve it iteratively?

class Solution {    //recursive soln
    static String[] rle = new String[31];

    static {
        rle[1] = "1";
    }

    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        if(rle[n] != null)
            return rle[n];
        
        String res = countAndSay(n-1);
        rle[n] = createRLE(res);
        return rle[n];
    }
    private static String createRLE(String s){
        StringBuilder res = new StringBuilder();
        char curr = s.charAt(0);
        int freq = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == curr){
                freq++;
            }
            else{
                res.append(freq);
                res.append(curr);
                curr = s.charAt(i);
                freq = 1;
            }
            
        }
        res.append(freq);
        res.append(curr);
        return res.toString();
    }
}

class Solution2 {
    String[] rle = new String[31];

    public String countAndSay(int n) {
        if(rle[n] != null)
            return rle[n];

        String res = "1";
        rle[1] = res;
        
        for(int i=2; i<=n; i++){
            res = createRLE(String.valueOf(res));
            rle[i] = res;
        }
        return rle[n];
    }
    private static String createRLE(String s){
        StringBuilder res = new StringBuilder();
        char curr = s.charAt(0);
        int freq = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == curr){
                freq++;
                continue;
            }
            res.append(String.valueOf(freq) + String.valueOf(curr));
            curr = s.charAt(i);
            freq = 1;
        }
        res.append(String.valueOf(freq) + String.valueOf(curr));
        return res.toString();
    }
}