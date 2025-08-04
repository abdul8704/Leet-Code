// Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.

// Examples:
// Input : s = "aababbcaacc" , k = 2
// Output : 6
// Explanation : The longest substring with at most two distinct characters is "aababb".
// The length of the string 6.

// Input : s = "abcddefg" , k = 3
// Output : 4
// Explanation : The longest substring with at most three distinct characters is "bcdd".
// The length of the string 4.

// Input : s = "abccab" , k = 4
// Output: 6

// 1 <= s.length <= 105
// 1 <= k <= 26

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int kDistinctChar(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0, N = s.length();

        for(int right = 0; right<N; right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(map.size() > k){
                if(map.get(s.charAt(left)) == 1)
                    map.remove(s.charAt(left));
                else
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;        
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}