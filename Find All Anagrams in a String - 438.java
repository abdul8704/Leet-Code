// Given two strings s and p, return an array of all the start indices of p's 
// anagrams in s. You may return the answer in any order.


// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 

// Constraints:

// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(p.length() > s.length()) return res;
        
        int[] freq = new int[26];
        int[] counter = new int[26];
        int P = p.length();

        for(int i=0; i<P; i++){
            freq[p.charAt(i) - 'a']++;
            counter[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freq, counter)) 
            res.add(0);
            
        for(int i=P; i<s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[s.charAt(i-P) - 'a']--;
            
            if(Arrays.equals(freq, counter)){
                res.add(i-P+1);
            }
        }
        return res;
    }
}