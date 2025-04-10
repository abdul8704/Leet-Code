// You are given two string arrays words1 and words2.
// A string b is a subset of string a if every letter in b occurs in a including multiplicity.
// For example, "wrr" is a subset of "warrior" but is not a subset of "world".
// A string a from words1 is universal if for every string b in words2, b is a subset of a.

// Return an array of all the universal strings in words1. You may return the answer in any order.

// Example 1:

// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
// Output: ["facebook","google","leetcode"]

// Example 2:

// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
// Output: ["apple","google","leetcode"]
 
// Constraints:

// 1 <= words1.length, words2.length <= 104
// 1 <= words1[i].length, words2[i].length <= 10
// words1[i] and words2[i] consist only of lowercase English letters.
// All the strings of words1 are unique.

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static int[] constructMap(String word){     //function generate a int array map of given string
        int[] map = new int[26];
        for(int i=0; i<word.length(); i++){
            map[word.charAt(i) - 'a']++;
        }
        return map;
    }

    private static boolean isSubset(int[] main, int[] sub){ //function to check if sub is subset of main
        for(int i=0; i<26; i++){
            if(sub[i] > main[i]){
                return false;
            }
        }
        return true;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        int[] count = new int[26];
        for(int i=0; i<words2.length; i++){         //combine all of the "words2" to a single entity and derive a map for it.
            int[] localCount = new int[26];
            for(int j=0; j<words2[i].length(); j++){
                localCount[words2[i].charAt(j) - 'a']++;
                count[words2[i].charAt(j) -'a'] = Math.max(count[words2[i].charAt(j) -'a'], localCount[words2[i].charAt(j) - 'a']);
            }
            
        }

        int map[] = new int[26];    
        
        for(int i=0; i<words1.length; i++){
            map = constructMap(words1[i]);          //check if each word is universal.
            if(isSubset(map, count)){
                res.add(words1[i]);
            }
        }

        return res;
    }
}

