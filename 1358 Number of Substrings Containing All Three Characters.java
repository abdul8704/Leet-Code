// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Example 1:
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

// Example 2:
// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

// Example 3:
// Input: s = "abc"
// Output: 1

// Constraints:
// 3 <= s.length <= 5 x 10^4
// s only consists of a, b or c characters.

class Solution {
    public int numberOfSubstrings(String s) {
        int[] map = new int[26];
        int count = 0, left = 0;

        for(int i=0; i<3; i++)
            map[s.charAt(i) - 'a']++;

        if(valid(map))
            count++;

        for(int right=3; right<s.length(); right++){
            map[s.charAt(right) - 'a']++;
            
            while(valid(map))
                map[s.charAt(left++) - 'a']--;

            count += left;
        }    

        return count;
    }
    private static boolean valid(int[] map){
        return (map[0] > 0 && map[1] > 0 && map[2] > 0);
    }    
}