// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

// Example 1:
// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.

// Example 2:
// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.

// Example 3:
// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

// Constraints:
// 1 <= s.length <= 105
// s consists of lowercase English letters.
// 1 <= k <= s.length

class Solution {
    static boolean isVowel(char c){
        if(c == 'a' || c=='e' || c== 'o' || c == 'u' || c=='i'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int res = 0, count = 0;

        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }

        res = count;
        
        for(int i=k; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            if(isVowel(s.charAt(i-k))){
                count--;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}