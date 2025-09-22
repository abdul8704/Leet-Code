// Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

// Example 1:
// Input: s = "0110111"
// Output: 9
// Explanation: There are 9 substring in total with only 1's characters.
// "1" -> 5 times.
// "11" -> 3 times.
// "111" -> 1 time.

// Example 2:
// Input: s = "101"
// Output: 2
// Explanation: Substring "1" is shown 2 times in s.

// Example 3:
// Input: s = "111111"
// Output: 21
// Explanation: Each substring contains only 1's characters.
 
// Constraints:
// 1 <= s.length <= 105
// s[i] is either '0' or '1'.

class Solution {
    public int numSub(String s) {
        long count = 0;
        int MOD = 1_000_000_007;
        int N  =s.length(), left = 0;

        while(left < N){
            if(s.charAt(left) == '1'){
                int right = left;

                while(right < N && s.charAt(right) == '1'){
                    right++;
                }
                long len = right - left;

                count = (count + ((len * (len + 1)) / 2)) % MOD;
                left = right;
            }
            else
                left++;
        }

        return (int)(count % MOD);
    }
}
class Solution2 {
    public int numSub(String s) {
        long count = 0;
        int MOD = 1_000_000_007;
        int ones = 0;

        for(char ch: s.toCharArray()){
            if(ch == '0')
                ones = 0;
            else{
                ones++;
                count = (count + ones)  % MOD;
                
            }
        }

        return (int)count;
    }
}